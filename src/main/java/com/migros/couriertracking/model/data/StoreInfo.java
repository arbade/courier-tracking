package com.migros.couriertracking.model.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class StoreInfo {

    private String name;
    private float lat;
    private float lng;

}
