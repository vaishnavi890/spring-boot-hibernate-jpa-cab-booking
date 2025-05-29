package com.vaishnavi.jpa.cab.booking.repository;

import com.vaishnavi.jpa.cab.booking.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}


