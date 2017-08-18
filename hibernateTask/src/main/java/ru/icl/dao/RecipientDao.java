package ru.icl.dao;


import ru.icl.models.Recipient;

import java.util.List;

public interface RecipientDao {

    Recipient getRecipientById(Long id);

    List<Recipient> findAll(Long userId);

    void saveOrUpdateRecipient(Recipient recipient);

    void deleteRecipient(Long id);
}
