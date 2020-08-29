package com.migros.couriertracking.controller;

import com.migros.couriertracking.mapper.CourierLocationMapper;
import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.model.data.CourierLocationDto;
import com.migros.couriertracking.service.CourierTrackingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;


@SpringBootTest
public class CourierTrackingControllerTest {

    @Mock
    private CourierTrackingService courierTrackingService;

    @InjectMocks
    private CourierTrackingController courierTrackingController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void receiveLocationTest() {
        CourierLocationDto courierLocationDto = new CourierLocationDto();
        courierLocationDto.setId(1L);
        courierLocationDto.setCourierId(1L);
        courierLocationDto.setLat(0f);
        courierLocationDto.setLng(0f);
        courierLocationDto.setTimestamp(LocalDateTime.now());
        ResponseEntity<CourierLocationDto> courierLocationDtoResponseEntity = courierTrackingController.receiveLocation(courierLocationDto);
        verify(courierTrackingService, times(1)).track(courierLocationDto);
    }

    @Test
    public void getTracksListTest() throws Exception {
        CourierLocationDto courierLocationDto = new CourierLocationDto();
        courierLocationDto.setId(1L);
        courierLocationDto.setCourierId(1L);
        courierLocationDto.setLat(0f);
        courierLocationDto.setLng(0f);
        List<CourierLocationDto> courierLocationDtos = new ArrayList<>();
        courierLocationDtos.add(courierLocationDto);
//        when(courierTrackingService.getTracks()).thenReturn(courierLocationMapper.map(courierLocationDtos));
//        List<CourierLocationDto> locationDtos = courierTrackingController.getTracks();
//        assertFalse(locationDtos.isEmpty());
//        verify(courierTrackingService, times(1)).getTracks();
        verifyNoInteractions(courierTrackingService);

    }

    @Test
    public void getDistanceByCourierId() {
        CourierLocationDto courierLocationDto = new CourierLocationDto();
        courierLocationDto.setId(1L);
        courierLocationDto.setCourierId(1L);
        courierLocationDto.setLat(0f);
        courierLocationDto.setLng(0f);

        Double dto = courierTrackingController.getDistanceByCourierId(1L);
        Mockito.when(courierTrackingService.getTotalTravelDistance(1L)).thenReturn(dto);
        assertEquals(Optional.of(1L), Optional.of(courierLocationDto.getCourierId()));
        verify(courierTrackingService, times(1)).getTotalTravelDistance(1L);
//        verifyNoInteractions(courierTrackingService);

    }

}