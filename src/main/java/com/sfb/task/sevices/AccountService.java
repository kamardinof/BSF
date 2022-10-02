package com.sfb.task.sevices;

import com.sfb.task.dto.AccountDTO;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public interface AccountService {

    AccountDTO getAccountDetails(Long accountId);

    AccountDTO createAccount(AccountDTO account);

    void addBalance(Long accountId, BigDecimal amount);

    void withdrawBalance(Long accountId, BigDecimal amount);

    void transferBalance(Long accountId1, Long accountId2, BigDecimal amount);

}
