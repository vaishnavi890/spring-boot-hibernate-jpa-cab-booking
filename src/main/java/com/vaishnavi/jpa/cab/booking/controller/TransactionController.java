package com.vaishnavi.jpa.cab.booking.controller;

import com.vaishnavi.jpa.cab.booking.model.TransactionModel;
import com.vaishnavi.jpa.cab.booking.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/transactionManagement")
public class TransactionController {

    @Resource(name = "transactionService")
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public List<TransactionModel> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transaction/{id}")
    public TransactionModel getTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/transaction")
    public TransactionModel saveTransaction(@RequestBody TransactionModel transactionModel) {
        return transactionService.saveTransaction(transactionModel);
    }

    @DeleteMapping("/transaction/{id}")
    public boolean deleteTransaction(@PathVariable int id) {
        return transactionService.deleteTransaction(id);
    }
}


