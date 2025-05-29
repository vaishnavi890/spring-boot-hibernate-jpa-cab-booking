package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.PaymentModel;
import java.util.List;

public interface PaymentService {
    PaymentModel makePayment(PaymentModel payment);
    boolean deletePayment(int paymentId);

    PaymentModel savePayment(PaymentModel model);

    boolean deletePayment(Long paymentId);

    List<PaymentModel> getAllPayments();
    PaymentModel getPaymentById(int paymentId);

    PaymentModel getPaymentById(Long paymentId);
}


