package com.migros.couriertracking.model.data;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourierLocationDto {

    private Long id;
    private Long courierId;
    private LocalDateTime timestamp;
    private float lat;
    private float lng;
}
