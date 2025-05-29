package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.Transaction;
import com.vaishnavi.jpa.cab.booking.model.TransactionModel;
import com.vaishnavi.jpa.cab.booking.repository.TransactionRepository;
import com.vaishnavi.jpa.cab.booking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionModel saveTransaction(TransactionModel model) {
        Transaction tx = populateTransactionEntity(model);
        return populateTransactionModel(transactionRepository.save(tx));
    }

    @Override
    public boolean deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
        return true;
    }

    @Override
    public List<TransactionModel> getAllTransactions() {
        List<TransactionModel> models = new ArrayList<>();
        transactionRepository.findAll().forEach(tx -> models.add(populateTransactionModel(tx)));
        return models;
    }

    @Override
    public TransactionModel getTransactionById(Long id) {
        return populateTransactionModel(transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found")));
    }

    private TransactionModel populateTransactionModel(Transaction tx) {
        TransactionModel model = new TransactionModel();
        model.setId(tx.getId());
        model.setUserId(tx.getUserId());
        model.setAmount(tx.getAmount());
        model.setDate(tx.getDate());
        model.setType(tx.getType());
        return model;
    }

    private Transaction populateTransactionEntity(TransactionModel model) {
        Transaction tx = new Transaction();
        tx.setUserId(model.getUserId());
        tx.setAmount(model.getAmount());
        tx.setDate(model.getDate());
        tx.setType(model.getType());
        return tx;
    }
}


