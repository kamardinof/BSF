package com.sfb.task.controllers;

import com.sfb.task.dto.AccountDTO;
import com.sfb.task.sevices.AccountService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    private AccountService accountService;

    @PostMapping("/create")
    public AccountDTO saveAccount(@RequestBody AccountDTO account){
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public AccountDTO getAccountDetails(@PathVariable Long id){
       return accountService.getAccountDetails(id);
    }

    @PostMapping("/transfer/from/{account_id1}/to/{account_id2}")
    public void transferFunds(@PathVariable Long account_id1, @PathVariable Long account_id2, @RequestParam BigDecimal amount){
        accountService.transferBalance(account_id1, account_id2, amount);
    }

}
