package com.migros.couriertracking.mapper;

import com.migros.couriertracking.model.CourierLocation;
import com.migros.couriertracking.model.data.CourierLocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper(config = MapperConfig.class)
public interface CourierLocationMapper {

    CourierLocation map(CourierLocationDto courierLocationDto);

    CourierLocationDto mapToDto(CourierLocation courierLocation);

    List<CourierLocation> map(List<CourierLocationDto> courierLocationDtoList);

    List<CourierLocationDto> courierLocationMapDtos(Collection<CourierLocation> courierLocations);

}
