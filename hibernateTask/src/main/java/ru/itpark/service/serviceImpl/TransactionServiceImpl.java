package ru.itpark.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.dao.PrimaryAccountDao;
import ru.itpark.dao.PrimaryTransactionDao;
import ru.itpark.dao.RecipientDao;
import ru.itpark.models.PrimaryAccount;
import ru.itpark.models.PrimaryTransaction;
import ru.itpark.models.Recipient;
import ru.itpark.models.User;
import ru.itpark.service.TransactionService;
import ru.itpark.service.UserService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private PrimaryTransactionDao primaryTransactionDao;

    @Autowired
    private RecipientDao recipientDao;

    public List<PrimaryTransaction> findPrimaryTransactionList(String username) {
        User user = userService.findByUsername(username);

        return primaryTransactionDao.findAll(user.getPrimaryAccount().getAccountNumber());
    }

    public void savePrimaryTransaction(PrimaryTransaction primaryTransaction) {
        primaryTransactionDao.save(primaryTransaction);
    }

    public List<Recipient> findRecipientList(Principal principal) {
        String username = principal.getName();

        return recipientDao.findAll(username);
    }

    public Recipient saveRecipient(Recipient recipient) {
        return recipientDao.save(recipient);
    }

    public Recipient findRecipientByAccountNumber(int recipientAccountNumber) {
        return recipientDao.findByAccountNumber(recipientAccountNumber);
    }

    public void deleteRecipientByAccountNumber(int recipientAccountNumber) {
        recipientDao.deleteByAccountNumber(recipientAccountNumber);
    }

    @Transactional
    public void toSomeoneElseTransfer(Recipient recipient, String amount, PrimaryAccount primaryAccount) {
        primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
        primaryAccountDao.save(primaryAccount);
        PrimaryAccount recipientPrimaryAccount = primaryAccountDao.findByAccountNumber(recipient.getRecipientAccountNumber());
        recipientPrimaryAccount.setAccountBalance(recipientPrimaryAccount.getAccountBalance().add(new BigDecimal(amount)));

        Date date = new Date();

        PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Перевод пользователю " + recipient.getName(), "Перевод", "Завершен", Double.parseDouble(amount), primaryAccount.getAccountBalance(), primaryAccount);
        primaryTransactionDao.save(primaryTransaction);
        PrimaryTransaction recipientPrimaryTransaction = new PrimaryTransaction(date, "Поступление", "Перевод", "Завершен", Double.parseDouble(amount), recipientPrimaryAccount.getAccountBalance(), recipientPrimaryAccount);
        primaryTransactionDao.save(recipientPrimaryTransaction);
    }
}
