package ru.icl.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.icl.models.Recipient;

import java.util.List;

@Component
public interface RecipientDao {

    List<Recipient> findAll();

    Recipient findByName(String recipientName);

    void deleteByName(String recipientName);

    Recipient save(Recipient recipient);
}
