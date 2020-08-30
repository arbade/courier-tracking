package com.migros.couriertracking.util;

public class DistanceCalculationUtil {

    public static double getDistanceOfTwoPoints(float lat1,float lng1,float lat2,float lng2){

        return  org.apache.lucene.util.SloppyMath.haversinMeters(lat1, lng1, lat2, lng2);
    }
}
