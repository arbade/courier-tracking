package com.migros.couriertracking.service;


import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.model.data.CourierLocationDto;
import com.migros.couriertracking.repository.CourierTrackingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourierTrackingService {

    @Autowired
    private CourierTrackingRepository courierTrackingRepository;

    public void track(CourierLocationDto courierLocationDto) {
        CourierLocation courierLocation = new CourierLocation();
        courierLocation.setCourierId(courierLocationDto.getCourierId());
        courierLocation.setLng(courierLocationDto.getLng());
        courierLocation.setLat(courierLocationDto.getLat());
        courierLocation.setTimestamp(courierLocationDto.getTimestamp());
        courierTrackingRepository.save(courierLocation);
    }
}
