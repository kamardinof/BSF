package com.sfb.task.exceptions;

import lombok.Data;

@Data
public class NotEnoughBalance extends RuntimeException {

    private final String message = "Not Enough Balance.";
}
