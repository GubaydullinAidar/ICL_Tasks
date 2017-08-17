package ru.icl.service;

import ru.icl.models.*;

import java.security.Principal;
import java.util.List;

public interface TransactionService {

    List<Transaction> findTransactionList(String username);
    void saveDepositTransaction(Transaction transaction);
    void saveWithdrawTransaction(Transaction transaction);

//    void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception;

    List<Recipient> findRecipientList(Principal principal);
    Recipient saveRecipient(Recipient recipient);
    Recipient findRecipientByName(String recipientName);
    void deleteRecipientByName(String recipientName);

 //   void toSomeoneElseTransfer(Recipient recipient, String accountType, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount);
}
