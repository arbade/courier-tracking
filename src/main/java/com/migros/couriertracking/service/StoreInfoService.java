package com.migros.couriertracking.service;


import com.migros.couriertracking.model.data.StoreInfo;
import com.migros.couriertracking.util.JsonUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.List;

@Service
@Slf4j
@Getter
public class StoreInfoService {

    private List<StoreInfo> storeInfoList;

    @PostConstruct
    public void init() throws IOException {

        File file = ResourceUtils.getFile("classpath:stores.json");
        String storeJsonContent = String.join("", Files.readAllLines(file.toPath()));
        storeInfoList = JsonUtil.getStoreInfoList(storeJsonContent);
        System.out.println(storeInfoList);
    }


}
