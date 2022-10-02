package com.sfb.task.mappers;

import com.sfb.task.entities.Transaction;
import com.sfb.task.dto.AccountTransactionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    private ModelMapper modelMapper;

    public TransactionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Transaction convertToEntity(AccountTransactionDTO accountTransactionDTO){
        return modelMapper.map(accountTransactionDTO, Transaction.class);
    }

    public AccountTransactionDTO convertToDTO(Transaction transaction){
        return modelMapper.map(transaction, AccountTransactionDTO.class);
    }
}
