package com.migros.couriertracking.service;

import com.migros.couriertracking.cache.CourierLocationCache;
import com.migros.couriertracking.mapper.CourierLocationMapper;
import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.repository.CourierTrackingRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.Mockito.*;

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

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createTrackTest() {
        //given

        //when

        //then
    }

    @Test
    public void getTracksTest() throws Exception {
        List<CourierLocation> courierLocations = Arrays.asList(new CourierLocation(1L, 1L, LocalDateTime.now(), 0f, 0f), new CourierLocation(2L, 2L, LocalDateTime.now(), 0f, 0f));
        when(courierTrackingRepository.findAll()).thenReturn(courierLocations);
        List<CourierLocation> locationListResult = courierTrackingService.getCourierLocations();
        System.out.println(locationListResult);
        verify(courierTrackingRepository, times(1)).findAll();
    }


}