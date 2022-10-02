package com.sfb.task.mappers;

import com.sfb.task.dto.AccountDTO;
import com.sfb.task.entities.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    private ModelMapper modelMapper;

    public AccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Account convertToEntity(AccountDTO accountDTO){
        return modelMapper.map(accountDTO, Account.class);
    }

    public AccountDTO convertToDTO(Account account){
        return modelMapper.map(account, AccountDTO.class);
    }
}
