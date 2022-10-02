package com.sfb.task.serviceImpl;

import com.sfb.task.dto.AccountDTO;
import com.sfb.task.entities.Account;
import com.sfb.task.entities.Transaction;
import com.sfb.task.exceptions.AccountNotFound;
import com.sfb.task.exceptions.NotEnoughBalance;
import com.sfb.task.mappers.AccountMapper;
import com.sfb.task.repositories.AccountRepository;
import com.sfb.task.repositories.TransactionRepository;
import com.sfb.task.sevices.AccountService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {

   private AccountRepository accountRepository;

   private AccountMapper accountMapper;

   private TransactionRepository transactionRepository;

    public AccountServiceImp(AccountRepository accountRepository, AccountMapper accountMapper, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AccountDTO getAccountDetails(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()){
           throw new AccountNotFound();
        }

        AccountDTO accountDTO = accountMapper.convertToDTO(account.get());
        return accountDTO;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = accountMapper.convertToEntity(accountDTO);
        return accountMapper.convertToDTO(accountRepository.save(account));
    }

    @Override
    @Async
    public void addBalance(Long accountId, BigDecimal amount) {
        Optional<Account> account = accountRepository.findById(accountId);

        if (account.isEmpty()){
            throw new AccountNotFound();
        }

        BigDecimal currentBalance = account.get().getBalance();
        BigDecimal newBalance = currentBalance.add(amount);
        accountRepository.updateBalance(accountId, newBalance);
        Transaction withdrawTransaction = new Transaction(account.get(), amount);
        transactionRepository.save(withdrawTransaction);
    }

    @Override
    @Async
    public void withdrawBalance(Long accountId, BigDecimal amount) {
        Optional<Account> account = accountRepository.findById(accountId);

        if (account.isEmpty()){
            throw new AccountNotFound();
        }

        BigDecimal currentBalance = account.get().getBalance();

        if (currentBalance.compareTo(amount) < 0){
            throw new NotEnoughBalance();
        }

        BigDecimal newBalance = currentBalance.subtract(amount);
        accountRepository.updateBalance(accountId, newBalance);
        Transaction withdrawTransaction = new Transaction(account.get(), amount.negate());
        transactionRepository.save(withdrawTransaction);
    }

    @Override
    @Transactional
    public void transferBalance(Long accountId1, Long accountId2, BigDecimal amount) {
        withdrawBalance(accountId1, amount);
        addBalance(accountId2, amount);
    }

}
