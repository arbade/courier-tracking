package com.migros.couriertracking.service;


import com.migros.couriertracking.mapper.CourierLocationMapper;
import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.model.data.CourierLocationDto;
import com.migros.couriertracking.model.data.StoreInfo;
import com.migros.couriertracking.repository.CourierTrackingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class CourierTrackingService {

    @Autowired
    private CourierTrackingRepository courierTrackingRepository;

    @Autowired
    private CourierLocationMapper courierLocationMapper;

    @Autowired
    private StoreInfoService storeInfoService;

    public void track(CourierLocationDto courierLocationDto) {
        for (StoreInfo storeInfo : storeInfoService.getStoreInfoList()) {
            double distance = getDistanceOfTwoPoints(storeInfo.getLat(), storeInfo.getLng(), courierLocationDto.getLat(), courierLocationDto.getLng());
            if(distance <100.0){
                log.info("{} has been entered location :{}",courierLocationDto.getCourierId(),storeInfo.getName());
            }
        }

        CourierLocation courierLocation = courierLocationMapper.map(courierLocationDto);
        courierTrackingRepository.save(courierLocation);
    }

    public List<CourierLocation> getTracks() throws Exception {
        List<CourierLocation> courierLocations = courierTrackingRepository.findAll();
        if (CollectionUtils.isEmpty(courierLocations)) {
            throw new Exception("No Track Found!");
        }
        return courierLocations;
    }

    public Double getTotalTravelDistance(Long courierId) {
        CourierLocation previousLocation = null;
        double totalDistance = 0.0;
        for (CourierLocation courierLocation : courierTrackingRepository.findAllByCourierIdOrderByTimestamp(courierId)) {
            if (previousLocation == null) {
                previousLocation = courierLocation;
                continue;
            }
            totalDistance += getDistanceOfTwoPoints(previousLocation.getLat(), previousLocation.getLng(), courierLocation.getLat(), courierLocation.getLng());
            previousLocation = courierLocation;
        }
        return totalDistance;
    }

    public double getDistanceOfTwoPoints(float lat1, float lng1, float lat2, float ln2) {
        return 0;
    }


}
