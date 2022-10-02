package com.sfb.task.controllers;

import com.sfb.task.dto.AccountTransactionDTO;
import com.sfb.task.entities.Transaction;
import com.sfb.task.sevices.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    TransactionService transactionService;

    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/accountId/{accountId}")
    public CompletableFuture<List<AccountTransactionDTO>> getTransactionsByAccountId(@PathVariable Long accountId){
       return transactionService.findAllTransactionsByAccountId(accountId);
    }

}
