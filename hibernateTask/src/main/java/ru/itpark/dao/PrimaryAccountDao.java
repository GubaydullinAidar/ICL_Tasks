package ru.itpark.dao;

import ru.itpark.models.PrimaryAccount;

public interface PrimaryAccountDao {

    PrimaryAccount findByAccountNumber(Integer accountNumber);

    PrimaryAccount save(PrimaryAccount primaryAccount);

    Integer getMaxAccountNumber();
}
