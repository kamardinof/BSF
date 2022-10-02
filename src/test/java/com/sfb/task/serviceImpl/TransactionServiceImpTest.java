package com.sfb.task.serviceImpl;

import com.sfb.task.mappers.TransactionMapper;
import com.sfb.task.repositories.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class TransactionServiceImpTest {

    @Mock
    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;
    private TransactionServiceImp transactionServiceImp;

    @BeforeEach
    void setUp() {
        transactionServiceImp  = new TransactionServiceImp(transactionRepository, transactionMapper);

    }

    @Test
    void findAllTransactionsByAccountId() {
        //given
        Long accountId = 123L;
        //when
        transactionServiceImp.findAllTransactionsByAccountId(accountId);
        //then
        verify(transactionRepository.findAllTransactionsByAccountId(accountId));
    }
}