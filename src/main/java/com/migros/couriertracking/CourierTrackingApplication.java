package com.migros.couriertracking;

import com.migros.couriertracking.util.JsonUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
public class CourierTrackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourierTrackingApplication.class, args);
//        try {
//            JsonUtil.parser("/Users/arbade/Desktop/courier-tracking/src/main/resources/stores.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
