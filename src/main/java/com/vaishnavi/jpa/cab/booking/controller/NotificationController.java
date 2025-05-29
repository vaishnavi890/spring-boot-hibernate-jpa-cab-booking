package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.NotificationModel;
import com.vaishnavi.jpa.cab.booking.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/notificationManagement")
public class NotificationController {

    @Resource(name = "notificationService")
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public List<NotificationModel> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/notification/{id}")
    public NotificationModel getNotificationById(@PathVariable int id) {
        return notificationService.getNotificationById(id);
    }

    @PostMapping("/notification")
    public NotificationModel saveNotification(@RequestBody NotificationModel notificationModel) {
        return notificationService.saveNotification(notificationModel);
    }

    @DeleteMapping("/notification/{id}")
    public boolean deleteNotification(@PathVariable int id) {
        return notificationService.deleteNotification(id);
    }
}



