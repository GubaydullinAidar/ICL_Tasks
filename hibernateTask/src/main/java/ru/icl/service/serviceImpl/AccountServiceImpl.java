package ru.icl.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.icl.dao.AccountDao;
import ru.icl.models.*;
import ru.icl.service.AccountService;
import ru.icl.service.TransactionService;
import ru.icl.service.UserService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static int nextAccountNumber = 11223145;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    public Account createAccount() {
        Account account = new Account();
        account.setAccountBalance(new BigDecimal(0.0));
        account.setAccountNumber(accountGen());

        //accountDao.save(account);

        return null;// accountDao.findByAccountNumber(account.getAccountNumber());
    }

    public void deposit(String accountType, double amount, Principal principal) {

        User user = userService.findByUsername(principal.getName());

        if (accountType.equalsIgnoreCase("Основной")) {
            Account account = user.getAccount();
            account.setAccountBalance(account.getAccountBalance().add(new BigDecimal(amount)));
            //accountDao.save(account);

            Date date = new Date();

            Transaction transaction = new Transaction(date, "Пополнение основного счета", amount, account.getAccountBalance(), account);
            transactionService.saveDepositTransaction(transaction);

        }
    }

    public void withdraw(String accountType, double amount, Principal principal) {

        User user = userService.findByUsername(principal.getName());

        if (accountType.equalsIgnoreCase("Основной")) {
            Account account = user.getAccount();
            account.setAccountBalance(account.getAccountBalance().subtract(new BigDecimal(amount)));
            //accountDao.save(account);

            Date date = new Date();

            Transaction transaction = new Transaction(date, "Списание с основного счета", amount, account.getAccountBalance(), account);
            transactionService.saveWithdrawTransaction(transaction);

        }
    }

    private int accountGen() {
        return ++nextAccountNumber;
    }

	

}
