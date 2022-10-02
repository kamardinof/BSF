package com.sfb.task.exceptions;

import lombok.Data;

@Data
public class SameAccountForbidden extends RuntimeException {
    private final String message = "Cannot Transfer To Same Account.";
}
