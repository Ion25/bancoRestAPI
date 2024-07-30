package com.banco.bancorestapi.domain.service;

import com.banco.bancorestapi.domain.entities.Cuenta;
import com.banco.bancorestapi.domain.entities.Pago;
import com.banco.bancorestapi.domain.exceptions.FondosInsuficientesException;
import org.springframework.stereotype.Service;

@Service
public class GestionPago {

    public void procesarPago(Cuenta cuenta, Pago pago) {
        if (cuenta.getSaldo() < pago.getMonto()) {
            throw new FondosInsuficientesException("Saldo insuficiente para realizar el pago.");
        }
        cuenta.debitar(pago.getMonto());
    }
}