//package ru.itpark.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ru.itpark.models.PrimaryAccount;
//import ru.itpark.models.PrimaryTransaction;
//import ru.itpark.models.User;
//import ru.itpark.service.AccountService;
//import ru.itpark.service.TransactionService;
//import ru.itpark.service.UserService;
//
//import java.security.Principal;
//import java.util.List;
//
//@Controller
//@RequestMapping("/account")
//public class AccountController {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    AccountService accountService;
//
//    @Autowired
//    TransactionService transactionService;
//
//    @RequestMapping("/primaryAccount")
//    public String primaryAccount(Model model, Principal principal) {
//
//        List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());
//
//        User user = userService.findByUsername(principal.getName());
//        PrimaryAccount primaryAccount = user.getPrimaryAccount();
//
//        model.addAttribute("primaryAccount", primaryAccount);
//        model.addAttribute("primaryTransactionList", primaryTransactionList);
//
//        return "primaryAccount";
//    }
//
//    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
//    public String deposit(Model model) {
//        model.addAttribute("amount", "");
//
//        return "deposit";
//    }
//
//    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
//    public String depositPost(@ModelAttribute("amount") String amount, Principal principal) {
//        accountService.deposit(Double.parseDouble(amount), principal);
//
//        return "redirect:/userFront";
//    }
//
//    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
//    public String withdraw(Model model) {
//        model.addAttribute("amount", "");
//
//        return "withdraw";
//    }
//
//    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
//    public String withdrawPost(@ModelAttribute("amount") String amount, Principal principal) {
//        accountService.withdraw(Double.parseDouble(amount), principal);
//
//        return "redirect:/userFront";
//    }
//
//
//}
