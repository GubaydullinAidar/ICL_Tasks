package ru.icl.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.icl.dao.*;
import ru.icl.models.*;
import ru.icl.service.TransactionService;
import ru.icl.service.UserService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private RecipientDao recipientDao;

    public List<Transaction> findTransactionList(String username) {
        User user = userService.findByUsername(username);

        return user.getAccount().getTransactionList();
    }

    public void saveDepositTransaction(Transaction transaction) {
        transactionDao.save(transaction);
    }

    public void saveWithdrawTransaction(Transaction transaction) {
        transactionDao.save(transaction);
    }

    /*@Override
    public void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception {
        if (transferFrom.equalsIgnoreCase("Primary") && transferTo.equalsIgnoreCase("Savings")) {
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));

            accountDao.save(primaryAccount);
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Перевод со счета 'Основной' на счет 'Сберегательный'", "Счет", "Завершен", Double.parseDouble(amount), primaryAccount.getAccountBalance(), primaryAccount);
            transactionDao.save(primaryTransaction);
        } else if (transferFrom.equalsIgnoreCase("Savings") && transferTo.equalsIgnoreCase("Primary")) {
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));

            accountDao.save(primaryAccount);
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Перевод со счета 'Сберегательный' на счет 'Основной'", "Счет", "Завершен", Double.parseDouble(amount), savingsAccount.getAccountBalance(), savingsAccount);
            savingsTransactionDao.save(savingsTransaction);
        } else {
            throw new Exception("Invalid Transfer");
        }
    }
*/
    public List<Recipient> findRecipientList(Principal principal) {
        String username = principal.getName();
        //List<Recipient> recipientList = recipientDao.findAll().stream()
      //          .filter(recipient->username.equals(recipient.getUser().getUsername()))
               // .collect(Collectors.toList());

        return null;// recipientList;
    }

    public Recipient saveRecipient(Recipient recipient) {
        return null;// recipientDao.save(recipient);
    }

    public Recipient findRecipientByName(String recipientName) {
        return null;// recipientDao.findByName(recipientName);
    }

    public void deleteRecipientByName(String recipientName) {
        //recipientDao.deleteByName(recipientName);
    }

    /*public void toSomeoneElseTransfer(Recipient recipient, String accountType, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) {
        if (accountType.equalsIgnoreCase("Основной")) {
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            accountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Перевод пользователю " + recipient.getName(), "Перевод", "Завершен", Double.parseDouble(amount), primaryAccount.getAccountBalance(), primaryAccount);
            transactionDao.save(primaryTransaction);
        } else if (accountType.equalsIgnoreCase("Сберегательный")) {
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Перевод пользователю " + recipient.getName(), "Перевод", "Завершен", Double.parseDouble(amount), savingsAccount.getAccountBalance(), savingsAccount);
            savingsTransactionDao.save(savingsTransaction);
        }
    }*/
}
