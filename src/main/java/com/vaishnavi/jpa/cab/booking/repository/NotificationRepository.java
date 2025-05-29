package com.vaishnavi.jpa.cab.booking.repository;

import com.vaishnavi.jpa.cab.booking.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}



