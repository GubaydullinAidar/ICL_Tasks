package ru.itpark.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.dao.PrimaryAccountDao;
import ru.itpark.models.PrimaryAccount;
import ru.itpark.models.PrimaryTransaction;
import ru.itpark.models.User;
import ru.itpark.service.AccountService;
import ru.itpark.service.TransactionService;
import ru.itpark.service.UserService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private static int nextAccountNumber = 11223145;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        return primaryAccountDao.save(primaryAccount);
    }

    public void deposit(double amount, Principal principal) {

        User user = userService.findByUsername(principal.getName());

        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
        primaryAccountDao.save(primaryAccount);

        Date date = new Date();

        PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Пополнение основного счета", "Счет", "Завершен", amount, primaryAccount.getAccountBalance(), primaryAccount);
        transactionService.savePrimaryDepositTransaction(primaryTransaction);
    }

    public void withdraw(double amount, Principal principal) {

        User user = userService.findByUsername(principal.getName());

        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
        primaryAccountDao.save(primaryAccount);

        Date date = new Date();

        PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Списание с основного счета", "Счет", "Завершен", amount, primaryAccount.getAccountBalance(), primaryAccount);
        transactionService.savePrimaryWithdrawTransaction(primaryTransaction);
    }

    private int accountGen() {
        return ++nextAccountNumber;
    }
}
