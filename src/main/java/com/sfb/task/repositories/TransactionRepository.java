package com.sfb.task.repositories;

import com.sfb.task.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t where t.account.id = :accountId")
    List<Transaction> findAllTransactionsByAccountId(Long accountId);

}
