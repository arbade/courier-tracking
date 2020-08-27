package com.migros.couriertracking.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.migros.couriertracking.model.data.StoreInfo;

import java.util.Collections;
import java.util.List;

import java.io.IOException;

public class JsonUtil {

    public static List<StoreInfo> getStoreInfoList(String storeJsonContent) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(List.class, StoreInfo.class);
            return objectMapper.readValue(storeJsonContent, collectionType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


}
