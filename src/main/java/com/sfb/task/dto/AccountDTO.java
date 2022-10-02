package com.sfb.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sfb.task.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    private Long id;

    private AccountType accountType;

    private boolean active;

    private Date createdDate;

    private Date updateDate;

    private BigDecimal balance;


}
