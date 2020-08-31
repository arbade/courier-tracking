package com.migros.couriertracking.service;


import com.migros.couriertracking.cache.CourierLocationCache;
import com.migros.couriertracking.mapper.CourierLocationMapper;
import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.model.data.CourierLocationDto;
import com.migros.couriertracking.model.data.StoreInfo;
import com.migros.couriertracking.repository.CourierTrackingRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.SloppyMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private CourierLocationCache courierLocationCache;

    public CourierLocation create(CourierLocationDto courierLocationDto) {

        saveToCacheIfNearStore(courierLocationDto);
        CourierLocation courierLocation = courierLocationMapper.map(courierLocationDto);
        return courierTrackingRepository.save(courierLocation);
    }

    private void saveToCacheIfNearStore(CourierLocationDto courierLocationDto) {
        if (!courierLocationCache.isExist(courierLocationDto.getCourierId())) {
            for (StoreInfo storeInfo : storeInfoService.getStoreInfoList()) {
                double distance = SloppyMath.haversinMeters(storeInfo.getLat(), storeInfo.getLng(), courierLocationDto.getLat(), courierLocationDto.getLng());
                if (distance < 100.0) {
                    courierLocationCache.put(courierLocationDto.getCourierId(), storeInfo.getName());
                    log.info("Courier {} has been entered location : {}", courierLocationDto.getCourierId(), storeInfo.getName());
                }
            }
        }
    }

    public List<CourierLocation> getCourierLocations() {
        return courierTrackingRepository.findAll();
    }

    public Double getTotalTravelDistance(Long courierId) {
        CourierLocation previousLocation = null;
        double totalDistance = 0.0;
        List<CourierLocation> courierLocations = courierTrackingRepository.findAllByCourierIdOrderByTimestamp(courierId);
        for (CourierLocation courierLocation : courierLocations) {
            if (previousLocation == null) {
                previousLocation = courierLocation;
                continue;
            }
            totalDistance += SloppyMath.haversinMeters(previousLocation.getLat(), previousLocation.getLng(), courierLocation.getLat(), courierLocation.getLng());
            previousLocation = courierLocation;
        }
        return totalDistance;
    }
}
