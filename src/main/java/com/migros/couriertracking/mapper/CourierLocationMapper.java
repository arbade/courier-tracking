package com.migros.couriertracking.mapper;

import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.model.data.CourierLocationDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CourierLocationMapper {

    CourierLocation map(CourierLocationDto courierLocationDto);

    List<CourierLocation> map(List<CourierLocationDto> courierLocationDtoList);
}
