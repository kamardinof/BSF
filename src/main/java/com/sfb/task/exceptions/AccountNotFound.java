package com.sfb.task.exceptions;

import lombok.Data;

@Data
public class AccountNotFound extends RuntimeException{

    private final String message = "Account Not Found.";

}
