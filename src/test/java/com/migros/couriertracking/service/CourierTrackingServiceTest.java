package com.migros.couriertracking.service;

import com.migros.couriertracking.cache.CourierLocationCache;
import com.migros.couriertracking.mapper.CourierLocationMapper;
import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.model.data.CourierLocationDto;
import com.migros.couriertracking.repository.CourierTrackingRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;


public class CourierTrackingServiceTest {

    @InjectMocks
    private CourierTrackingService courierTrackingService;

    @InjectMocks
    private StoreInfoService storeInfoService;

    @Mock
    private CourierLocationCache courierLocationCache;

    @Mock
    private CourierLocationMapper courierLocationMapper;

    @Mock
    private CourierTrackingRepository courierTrackingRepository;

    @Mock
    private CourierLocation courierLocationMock;

    @Mock
    private CourierLocationDto courierLocationDtoMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create_ShouldCreateNew_WhenParamsAreValid() {
        CourierLocationDto courierLocationDto = new CourierLocationDto();
        courierLocationDto.setId(1L);
        courierLocationDto.setCourierId(1L);
        courierLocationDto.setLat(0f);
        courierLocationDto.setLng(0f);
        courierLocationDto.setTimestamp(LocalDateTime.now());
        //when
//        Mockito.when(courierTrackingService.create(courierLocationDto)).thenReturn(courierLocationMock);
        Mockito.when(courierLocationMapper.map(courierLocationDtoMock)).thenReturn(courierLocationMock);

        CourierLocation dto = courierTrackingRepository.save(courierLocationMock);
        CourierLocation courierLocation = courierLocationMapper.map(courierLocationDto);


        //then
//        assertNotEquals(courierLocation);
//        assertFalse(courierLocation.);
//
////        verify(courierTrackingService, times(1)).create(courierLocationDto);
//        verify(courierLocationMapper, times(1)).map((List<CourierLocationDto>) courierLocationMock);
//        verifyNoMoreInteractions(courierTrackingService, courierLocationMapper);
    }

    @Test
    public void getCourierLocations_ShouldReturnList_WhenLocationsDoExists() {
        //given
        //when
        Mockito.when(courierTrackingRepository.findAll()).thenReturn(Collections.singletonList(courierLocationMock));
        Mockito.when(courierTrackingService.getCourierLocations()).thenReturn(Collections.singletonList(courierLocationMock));
        List<CourierLocation> courierLocations = courierTrackingService.getCourierLocations();

        //then
        assertNotNull(courierLocations);
        assertFalse(courierLocations.isEmpty());

        verify(courierTrackingRepository, times(1)).findAll();
        verifyNoMoreInteractions(courierTrackingRepository);
    }


}