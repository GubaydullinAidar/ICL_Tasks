package ru.itpark.service;

import ru.itpark.models.*;

import java.security.Principal;
import java.util.List;

public interface TransactionService {

    List<PrimaryTransaction> findPrimaryTransactionList(String username);
    void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);
    void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction);

    List<Recipient> findRecipientList(Principal principal);
    Recipient saveRecipient(Recipient recipient);
    Recipient findRecipientByAccountNumber(int recipientAccountNumber);
    void deleteRecipientByAccountNumber(int recipientAccountNumber);

    void toSomeoneElseTransfer(Recipient recipient, String amount, PrimaryAccount primaryAccount);
}
