package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.Notification;
import com.vaishnavi.jpa.cab.booking.model.NotificationModel;
import com.vaishnavi.jpa.cab.booking.repository.NotificationRepository;
import com.vaishnavi.jpa.cab.booking.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationModel saveNotification(NotificationModel model) {
        Notification notif = populateNotificationEntity(model);
        return populateNotificationModel(notificationRepository.save(notif));
    }

    @Override
    public boolean deleteNotification(Long id) {
        notificationRepository.deleteById(id);
        return true;
    }

    @Override
    public List<NotificationModel> getAllNotifications() {
        List<NotificationModel> models = new ArrayList<>();
        notificationRepository.findAll().forEach(n -> models.add(populateNotificationModel(n)));
        return models;
    }

    @Override
    public NotificationModel getNotificationById(Long id) {
        return populateNotificationModel(notificationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notification not found")));
    }

    private NotificationModel populateNotificationModel(Notification n) {
        NotificationModel model = new NotificationModel();
        model.setId(n.getId());
        model.setMessage(n.getMessage());
        model.setUserId(n.getUserId());
        return model;
    }

    private Notification populateNotificationEntity(NotificationModel model) {
        Notification n = new Notification();
        n.setMessage(model.getMessage());
        n.setUserId(model.getUserId());
        return n;
    }
}

