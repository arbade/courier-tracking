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

@SpringBootTest
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
//        CourierLocationDto courierLocationDto = new CourierLocationDto();
//        when(!courierLocationCache.isExist(courierLocationDto.getCourierId())).thenReturn(true);
//        Iterator<StoreInfo> iterator = mock(Iterator.class);
//        List<StoreInfo> infoList = mock(List.class);
//        StoreInfo storeInfo = mock(StoreInfo.class);
//        when(infoList.iterator()).thenReturn(iterator);
////        OngoingStubbing<Double> distance = when(courierTrackingService.getDistanceOfTwoPoints(1f, 1f, 1f, 1f)).thenReturn();
////        assertEquals(0f, distance);
//        CourierLocation courierLocation = new CourierLocation();
//        courierLocation.setCourierId(1L);
//        courierLocation.setLat(0f);
//        courierLocation.setLng(0f);
//        courierLocation.setTimestamp(courierLocation.getTimestamp());
//        courierLocation.setId(1L);
//        courierLocation = courierLocationMapper.map(courierLocationDto);
////        CourierLocation courierLocation = courierLocationMapper.map(courierLocationDto);
//        when(courierTrackingRepository.save(courierLocation)).thenAnswer(new Answer<CourierLocation>() {
//            @Override
//            public CourierLocation answer(InvocationOnMock invocationOnMock) throws Throwable {
//                return null;
//            }
//        });
//        courierTrackingRepository.save(courierLocation);
////        assertNotNull(courierLocation.getCourierId());
//        assertEquals(1L, courierLocation.getCourierId());
//        assertEquals(1L, courierLocation.getId());
//        assertEquals(0f, courierLocation.getLat());
//        assertEquals(0f, courierLocation.getLng());


    }

    @Test
    public void getTracksTest() throws Exception {
        List<CourierLocation> courierLocations = Arrays.asList(new CourierLocation(1L, 1L, LocalDateTime.now(), 0f, 0f), new CourierLocation(2L, 2L, LocalDateTime.now(), 0f, 0f));
        when(courierTrackingRepository.findAll()).thenReturn(courierLocations);
        List<CourierLocation> locationListResult = courierTrackingService.getTracks();
        System.out.println(locationListResult);
        verify(courierTrackingRepository, times(1)).findAll();
    }


}