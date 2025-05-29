package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.Payment;
import com.vaishnavi.jpa.cab.booking.model.PaymentModel;
import com.vaishnavi.jpa.cab.booking.repository.PaymentRepository;
import com.vaishnavi.jpa.cab.booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentModel savePayment(PaymentModel model) {
        Payment payment = populatePaymentEntity(model);
        return populatePaymentModel(paymentRepository.save(payment));
    }

    @Override
    public boolean deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
        return true;
    }

    @Override
    public List<PaymentModel> getAllPayments() {
        List<PaymentModel> models = new ArrayList<>();
        paymentRepository.findAll().forEach(payment -> models.add(populatePaymentModel(payment)));
        return models;
    }

    @Override
    public PaymentModel getPaymentById(Long paymentId) {
        return populatePaymentModel(paymentRepository.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found")));
    }

    private PaymentModel populatePaymentModel(Payment payment) {
        PaymentModel model = new PaymentModel();
        model.setId(payment.getId());
        model.setRideId(payment.getRideId());
        model.setUserId(payment.getUserId());
        model.setAmount(payment.getAmount());
        model.setPaymentMethod(payment.getPaymentMethod());
        model.setStatus(payment.getStatus());
        return model;
    }

    private Payment populatePaymentEntity(PaymentModel model) {
        Payment payment = new Payment();
        payment.setRideId(model.getRideId());
        payment.setUserId(model.getUserId());
        payment.setAmount(model.getAmount());
        payment.setPaymentMethod(model.getPaymentMethod());
        payment.setStatus(model.getStatus());
        return payment;
    }
}


