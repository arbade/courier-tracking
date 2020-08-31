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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CourierTrackingControllerTest {

    @Mock
    private CourierLocationMapper courierLocationMapper;
    @Mock
    private CourierTrackingService courierTrackingService;
    @InjectMocks
    private CourierTrackingController courierTrackingController;

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
        //given
        CourierLocationDto courierLocationDto = new CourierLocationDto();
        courierLocationDto.setId(1L);
        courierLocationDto.setCourierId(1L);
        courierLocationDto.setLat(0f);
        courierLocationDto.setLng(0f);
        courierLocationDto.setTimestamp(LocalDateTime.now());
        //when
        Mockito.when(courierTrackingService.create(courierLocationDto)).thenReturn(courierLocationMock);
        Mockito.when(courierLocationMapper.mapToDto(courierLocationMock)).thenReturn(courierLocationDtoMock);

        ResponseEntity<CourierLocationDto> responseEntity = courierTrackingController.create(courierLocationDto);

        //then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertTrue(responseEntity.hasBody());

        verify(courierTrackingService, times(1)).create(courierLocationDto);
        verify(courierLocationMapper, times(1)).mapToDto(courierLocationMock);
        verifyNoMoreInteractions(courierTrackingService, courierLocationMapper);
    }


    @Test
    public void getCourierLocations_ShouldReturnList_WhenLocationsDoExists() {
        //given
        //when
        Mockito.when(courierTrackingService.getCourierLocations()).thenReturn(Collections.singletonList(courierLocationMock));
        Mockito.when(courierLocationMapper.courierLocationMapDtos(Collections.singletonList(courierLocationMock)))
                .thenReturn(Collections.singletonList(courierLocationDtoMock));

        List<CourierLocationDto> courierLocations = courierTrackingController.getCourierLocations();

        //then
        assertNotNull(courierLocations);
        assertFalse(courierLocations.isEmpty());

        verify(courierTrackingService, times(1)).getCourierLocations();
        verify(courierLocationMapper, times(1))
                .courierLocationMapDtos(Collections.singletonList(courierLocationMock));
        verifyNoMoreInteractions(courierTrackingService, courierLocationMapper);
    }


    @Test
    public void getTotalTravelDistance_ShouldReturnTotalTravelDistance_WhenCourierLocationsDoExists() {
        //given
        Long courierId = 5L;
        //when
        Double distance = 230.00;
        Mockito.when(courierTrackingService.getTotalTravelDistance(courierId)).thenReturn(distance);

        Double totalTravelDistance = courierTrackingController.getTotalTravelDistance(courierId);

        //then
        assertNotNull(totalTravelDistance);
        assertEquals(distance, totalTravelDistance);


        verify(courierTrackingService, times(1)).getTotalTravelDistance(courierId);
        verifyNoMoreInteractions(courierTrackingService, courierLocationMapper);
    }


}