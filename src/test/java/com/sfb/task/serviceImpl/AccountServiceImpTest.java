package com.sfb.task.serviceImpl;

import com.sfb.task.entities.Account;
import com.sfb.task.enums.AccountType;
import com.sfb.task.exceptions.AccountNotFound;
import com.sfb.task.mappers.AccountMapper;
import com.sfb.task.repositories.AccountRepository;
import com.sfb.task.repositories.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServiceImpTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    private AccountServiceImp accountServiceImp;

    private AccountMapper accountMapper;

    @BeforeEach
    void setUp() {
        accountServiceImp = new AccountServiceImp(accountRepository, accountMapper, transactionRepository);
    }

    @Test
    void getAccountDetails() {
        //given
        Long accountId = 123L;
        //when
        accountServiceImp.getAccountDetails(accountId);
        //
        verify(accountRepository.findById(accountId));
    }

    @Test
    void createAccount() {
        //given
        Account account = new Account(123L, AccountType.DEBIT, true, new Date(), new Date(), BigDecimal.ONE);
        //when
        accountServiceImp.createAccount(accountMapper.convertToDTO(account));
        //then
        verify(accountRepository).save(account);
    }


    @Test
    void transferBalance() {
        //when
        accountServiceImp.withdrawBalance(123L, BigDecimal.TEN);
        //then
        verify(accountRepository).updateBalance(123L,  BigDecimal.TEN);
    }
}