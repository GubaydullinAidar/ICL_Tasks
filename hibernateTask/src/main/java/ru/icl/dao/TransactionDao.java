package ru.icl.dao;

import ru.icl.models.Transaction;

public interface TransactionDao {
    void save(Transaction transaction);
}
