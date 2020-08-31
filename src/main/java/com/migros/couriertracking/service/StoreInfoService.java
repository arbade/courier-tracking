package com.migros.couriertracking.service;


import com.migros.couriertracking.model.data.StoreInfo;
import com.migros.couriertracking.util.JsonUtil;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Getter
public class StoreInfoService {

    private List<StoreInfo> storeInfoList;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = getClass().getResourceAsStream("/stores.json");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            storeInfoList = JsonUtil.getStoreInfoList(contents);
            System.out.println(storeInfoList);
        }
    }


}
