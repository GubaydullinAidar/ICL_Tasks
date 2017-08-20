package ru.itpark.dao;

import ru.itpark.models.PrimaryTransaction;

import java.util.List;

public interface PrimaryTransactionDao {
    void save(PrimaryTransaction primaryTransaction);

    List<PrimaryTransaction> findAll(Integer accountNumber);
}
