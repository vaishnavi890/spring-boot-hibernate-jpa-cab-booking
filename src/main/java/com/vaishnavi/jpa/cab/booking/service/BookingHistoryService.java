package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.BookingHistoryModel;
import java.util.List;

public interface BookingHistoryService {
    BookingHistoryModel saveHistory(BookingHistoryModel history);
    boolean deleteHistory(int historyId);
    List<BookingHistoryModel> getAllHistories();
    BookingHistoryModel getHistoryById(int historyId);

    BookingHistoryModel saveBookingHistory(BookingHistoryModel model);

    boolean deleteBookingHistory(Long id);

    List<BookingHistoryModel> getAllBookingHistories();

    BookingHistoryModel getBookingHistoryById(Long id);
}


