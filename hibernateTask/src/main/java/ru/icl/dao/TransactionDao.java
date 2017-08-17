package ru.icl.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.icl.models.Transaction;

@Component
public interface TransactionDao {
    void save(Transaction transaction);
}
