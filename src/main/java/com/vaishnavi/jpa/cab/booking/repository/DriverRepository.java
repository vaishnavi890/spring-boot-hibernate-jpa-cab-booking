package com.vaishnavi.jpa.cab.booking.repository;

import com.vaishnavi.jpa.cab.booking.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}


