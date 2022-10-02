package com.sfb.task.serviceImpl;


import com.sfb.task.dto.AccountTransactionDTO;
import com.sfb.task.entities.Transaction;
import com.sfb.task.mappers.TransactionMapper;
import com.sfb.task.repositories.TransactionRepository;
import com.sfb.task.sevices.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImp implements TransactionService {

    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;

    public TransactionServiceImp(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public CompletableFuture<List<AccountTransactionDTO>> findAllTransactionsByAccountId(Long account_id) {
        List<Transaction> listOfTransactions = transactionRepository.findAllTransactionsByAccountId(account_id);
        return CompletableFuture.completedFuture(listOfTransactions.stream().map(transaction -> transactionMapper.convertToDTO(transaction)).collect(Collectors.toList()));
    }

}
