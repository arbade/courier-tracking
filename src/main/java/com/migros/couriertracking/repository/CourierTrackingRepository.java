package com.migros.couriertracking.repository;


import com.migros.couriertracking.model.CourierLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourierTrackingRepository extends JpaRepository<CourierLocation, Long> {

    List<CourierLocation> findAllByCourierIdOrderByTimestamp(Long courierId);
}
