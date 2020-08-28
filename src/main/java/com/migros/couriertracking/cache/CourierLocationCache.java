package com.migros.couriertracking.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


@Component
public class CourierLocationCache {

    private Cache<Long, String> cache;

    @PostConstruct
    public void init() {
        cache = CacheBuilder.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .build();
    }

    public void put(Long courierId, String storeName) {
        cache.put(courierId, storeName);
    }

    public Boolean isExist(Long courierId) {
        return cache.getIfPresent(courierId) != null;
    }

}
