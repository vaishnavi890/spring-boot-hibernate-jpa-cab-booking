package com.vaishnavi.jpa.cab.booking.repository;

import com.vaishnavi.jpa.cab.booking.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}


