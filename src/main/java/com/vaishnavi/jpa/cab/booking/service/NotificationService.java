package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.NotificationModel;
import java.util.List;

public interface NotificationService {
    NotificationModel sendNotification(NotificationModel notification);
    boolean deleteNotification(int notificationId);

    NotificationModel saveNotification(NotificationModel model);

    boolean deleteNotification(Long id);

    List<NotificationModel> getAllNotifications();
    NotificationModel getNotificationById(int notificationId);

    NotificationModel getNotificationById(Long id);
}


