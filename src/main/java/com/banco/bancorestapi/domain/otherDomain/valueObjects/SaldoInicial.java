package com.banco.bancorestapi.domain.otherDomain.valueObjects;

public class SaldoInicial {

    private double saldo;

    public SaldoInicial(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }
}