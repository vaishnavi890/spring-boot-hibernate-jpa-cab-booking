package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.TransactionModel;
import java.util.List;

public interface TransactionService {
    TransactionModel recordTransaction(TransactionModel transaction);
    boolean deleteTransaction(int transactionId);

    TransactionModel saveTransaction(TransactionModel model);

    boolean deleteTransaction(Long id);

    List<TransactionModel> getAllTransactions();
    TransactionModel getTransactionById(int transactionId);

    TransactionModel getTransactionById(Long id);
}


