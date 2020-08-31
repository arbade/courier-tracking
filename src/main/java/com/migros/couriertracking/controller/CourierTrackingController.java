package com.migros.couriertracking.controller;


import com.migros.couriertracking.mapper.CourierLocationMapper;
import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.model.data.CourierLocationDto;
import com.migros.couriertracking.service.CourierTrackingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/courier-locations")
@Api(value = "Courier Tracking Management System", description = "Operations pertaining to courier tracking in Case Demo")
@RequiredArgsConstructor
@Slf4j
public class CourierTrackingController {

    @Autowired
    private CourierTrackingService courierTrackingService; // service

    @Autowired
    private CourierLocationMapper courierLocationMapper;


    @PostMapping
    @ApiOperation(value = "Create new  Courier Location")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(code = 201, message = "CourierLocationDto")
    public ResponseEntity create(@RequestBody CourierLocationDto courierLocationDto) {

        log.info("Create CourierLocation request is started. CourierLocationDto: {}", courierLocationDto);
        CourierLocation courierLocationSaved = courierTrackingService.create(courierLocationDto);
        CourierLocationDto saved = courierLocationMapper.mapToDto(courierLocationSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    @ApiOperation(value = "Get all courier locations")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(code = 200, message = "Courier Locations")
    public List<CourierLocationDto> getCourierLocations() {

        List<CourierLocation> courierLocations = courierTrackingService.getCourierLocations();
        return courierLocationMapper.courierLocationMapDtos(courierLocations);
    }

    @ApiOperation(value = "Get total distance of courier")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/total-distance/{courierId}")
    @ApiResponse(code = 200, message = "Total Distance")
    public Double getTotalTravelDistance(@ApiParam(value = "courierId of courier", required = true, example = "1") @PathVariable Long courierId) {

        return courierTrackingService.getTotalTravelDistance(courierId);
    }

}
