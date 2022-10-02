package com.sfb.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account_transactions")
public class Transaction {

    public Transaction(Account account, BigDecimal transactionAmount) {
        this.account = account;
        this.transactionAmount = transactionAmount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    private BigDecimal transactionAmount;

    @CreationTimestamp
    private Date transactionDate;


}
