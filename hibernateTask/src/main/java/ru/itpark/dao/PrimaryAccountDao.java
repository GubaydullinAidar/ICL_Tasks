package ru.itpark.dao;

import ru.itpark.models.PrimaryAccount;

public interface PrimaryAccountDao {

    PrimaryAccount findByAccountNumber(int accountNumber);

    PrimaryAccount save(PrimaryAccount primaryAccount);
}
