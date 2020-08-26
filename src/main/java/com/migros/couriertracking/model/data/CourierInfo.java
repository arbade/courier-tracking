package com.migros.couriertracking.model.data;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourierInfo {

    private String locationName;
    private float lat;
    private float lng;

}
