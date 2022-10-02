package com.sfb.task.sevices;

import com.sfb.task.dto.AccountTransactionDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface TransactionService {

    CompletableFuture<List<AccountTransactionDTO>> findAllTransactionsByAccountId(Long account_id);

}
