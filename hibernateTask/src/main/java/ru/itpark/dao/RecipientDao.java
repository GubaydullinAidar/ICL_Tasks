package ru.itpark.dao;

import ru.itpark.models.Recipient;

import java.util.List;

public interface RecipientDao {

    List<Recipient> findAll(String username);

    Recipient findByAccountNumber(int recipientAccountNumber);

    void deleteByAccountNumber(int recipientAccountNumber);

    Recipient save(Recipient recipient);
}
