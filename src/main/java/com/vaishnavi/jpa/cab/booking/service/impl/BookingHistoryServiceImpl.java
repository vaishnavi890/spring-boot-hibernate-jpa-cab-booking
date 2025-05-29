package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.BookingHistory;
import com.vaishnavi.jpa.cab.booking.model.BookingHistoryModel;
import com.vaishnavi.jpa.cab.booking.repository.BookingHistoryRepository;
import com.vaishnavi.jpa.cab.booking.service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("bookingHistoryService")
public class BookingHistoryServiceImpl implements BookingHistoryService {

    @Autowired
    private BookingHistoryRepository historyRepository;

    @Override
    public BookingHistoryModel saveBookingHistory(BookingHistoryModel model) {
        BookingHistory bh = populateEntity(model);
        return populateModel(historyRepository.save(bh));
    }

    @Override
    public boolean deleteBookingHistory(Long id) {
        historyRepository.deleteById(id);
        return true;
    }

    @Override
    public List<BookingHistoryModel> getAllBookingHistories() {
        List<BookingHistoryModel> models = new ArrayList<>();
        historyRepository.findAll().forEach(bh -> models.add(populateModel(bh)));
        return models;
    }

    @Override
    public BookingHistoryModel getBookingHistoryById(Long id) {
        return populateModel(historyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking history not found")));
    }

    private BookingHistoryModel populateModel(BookingHistory bh) {
        BookingHistoryModel model = new BookingHistoryModel();
        model.setId(bh.getId());
        model.setUserId(bh.getUserId());
        model.setRideId(bh.getRideId());
        model.setBookingTime(bh.getBookingTime());
        return model;
    }

    private BookingHistory populateEntity(BookingHistoryModel model) {
        BookingHistory bh = new BookingHistory();
        bh.setUserId(model.getUserId());
        bh.setRideId(model.getRideId());
        bh.setBookingTime(model.getBookingTime());
        return bh;
    }
}


