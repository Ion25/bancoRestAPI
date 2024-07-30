package com.banco.bancorestapi.domain.service;

import com.banco.bancorestapi.domain.entities.Cuenta;
import org.springframework.stereotype.Service;

@Service
public class GestionTransferencia {

    public void realizarTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto de la transferencia debe ser positivo");
        }
        if (cuentaOrigen.getSaldo() < monto) {
            throw new IllegalArgumentException("Fondos insuficientes en la cuenta de origen");
        }
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
    }
}
