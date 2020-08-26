package com.migros.couriertracking.controller;


import com.migros.couriertracking.mapper.CourierLocationMapper;
import com.migros.couriertracking.model.data.CourierLocationDto;
import com.migros.couriertracking.service.CourierTrackingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
@Api(value = "Courier Tracking Management System", description = "Operations pertaining to courier tracking in Case Demo")
@RequiredArgsConstructor
@Slf4j
public class CourierTrackingController {

    @Autowired
    CourierTrackingService courierTrackingService; // service


    @PostMapping("/receiveLocation")
    @ApiOperation(value = "Receive Courier Location")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(code = 200, message = "Receive Location!")
    public ResponseEntity receiveLocation(@RequestBody CourierLocationDto courierLocationDto) {
        log.info("Receive Tracking:{}", courierLocationDto);
        courierTrackingService.track(courierLocationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/tracks")
    @ApiOperation(value = "All Recorded Tracks")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(code = 200, message = "Tracks Listed")
    public List<CourierLocationDto> getTracks() throws Exception {
        return CourierLocationMapper.INSTANCE.courierLocationMapDtos(courierTrackingService.getTracks());

    }

}
