package ru.icl.dao;

import ru.icl.models.Transaction;

import java.util.List;

public interface TransactionDao {

    List<Transaction> findAll(Long userId);

    void saveTransaction(Transaction transaction);

    void deleteTransaction(Long id);
}
