package com.vaishnavi.jpa.cab.booking.repository;

import com.vaishnavi.jpa.cab.booking.domain.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
}



