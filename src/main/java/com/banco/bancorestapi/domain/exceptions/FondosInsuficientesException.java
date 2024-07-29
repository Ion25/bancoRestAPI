package com.banco.bancorestapi.domain.exceptions;

public class FondosInsuficientesException extends RuntimeException {
    public FondosInsuficientesException(String message) {
        super(message);
    }
}