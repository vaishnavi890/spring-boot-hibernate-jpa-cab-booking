package com.vaishnavi.jpa.cab.booking.model;

import lombok.Data;

@Data
public class NotificationModel {
    private int notificationId;
    private int userId;
    private String message;
    private String timestamp;
    private boolean isRead;
}


