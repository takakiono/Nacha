package com.example.nacha.common.exception;

import com.example.nacha.common.constants.ErrorMessage;

public class NachaBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String error = "NachaBusinessException";

    public NachaBusinessException(ErrorMessage message) {
        super(message.getMessage());
    }

    public String getError() {
        return error;
    }

}