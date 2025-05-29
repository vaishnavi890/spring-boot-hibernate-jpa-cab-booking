package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.PaymentModel;
import com.vaishnavi.jpa.cab.booking.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/paymentManagement")
public class PaymentController {

    @Resource(name = "paymentService")
    private PaymentService paymentService;

    @GetMapping("/payments")
    public List<PaymentModel> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/payment/{id}")
    public PaymentModel getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/payment")
    public PaymentModel savePayment(@RequestBody PaymentModel paymentModel) {
        return paymentService.savePayment(paymentModel);
    }

    @DeleteMapping("/payment/{id}")
    public boolean deletePayment(@PathVariable Long id) {
        return paymentService.deletePayment(id);
    }
}


