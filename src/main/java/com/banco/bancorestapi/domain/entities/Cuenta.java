package com.banco.bancorestapi.domain.entities;

import com.banco.bancorestapi.domain.exceptions.FondosInsuficientesException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String numeroCuenta;
    private double saldo;
    private String tipoCuenta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void debitar(double monto) {
        if (saldo < monto) {
            throw new FondosInsuficientesException("Fondos insuficientes para realizar la operación.");
        }
        saldo = saldo - monto;
    }
}