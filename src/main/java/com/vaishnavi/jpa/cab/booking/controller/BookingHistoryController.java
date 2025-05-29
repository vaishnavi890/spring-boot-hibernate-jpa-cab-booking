package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.BookingHistoryModel;
import com.vaishnavi.jpa.cab.booking.service.BookingHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bookingHistoryManagement")
public class BookingHistoryController {

    @Resource(name = "bookingHistoryService")
    private BookingHistoryService bookingHistoryService;

    @GetMapping("/histories")
    public List<BookingHistoryModel> getAllBookingHistories() {
        return bookingHistoryService.getAllBookingHistories();
    }

    @GetMapping("/history/{id}")
    public BookingHistoryModel getBookingHistoryById(@PathVariable int id) {
        return bookingHistoryService.getBookingHistoryById((long) id);
    }

    @PostMapping("/history")
    public BookingHistoryModel saveBookingHistory(@RequestBody BookingHistoryModel model) {
        return bookingHistoryService.saveBookingHistory(model);
    }

    @DeleteMapping("/history/{id}")
    public boolean deleteBookingHistory(@PathVariable int id) {
        return bookingHistoryService.deleteBookingHistory((long) id);
    }
}

