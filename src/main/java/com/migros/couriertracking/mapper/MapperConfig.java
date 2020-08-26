package com.migros.couriertracking.mapper;


import org.mapstruct.CollectionMappingStrategy;

@org.mapstruct.MapperConfig(componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public class MapperConfig {
}



