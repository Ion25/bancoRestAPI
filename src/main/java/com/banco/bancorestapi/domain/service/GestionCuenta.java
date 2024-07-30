package com.banco.bancorestapi.domain.service;

import com.banco.bancorestapi.domain.entities.Cuenta;
import com.banco.bancorestapi.domain.otherDomain.valueObjects.SaldoInicial;
import org.springframework.stereotype.Service;

@Service
public class GestionCuenta {

    public void abrirCuenta(Cuenta cuenta, SaldoInicial saldoInicial) {
        cuenta.setSaldo(saldoInicial.getSaldo());
        // Agregar reglas de negocio adicionales aquí si es necesario
    }

    public void depositar(Cuenta cuenta, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del depósito debe ser positivo");
        }
        cuenta.setSaldo(cuenta.getSaldo() + monto);
    }

    public void retirar(Cuenta cuenta, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del retiro debe ser positivo");
        }
        if (cuenta.getSaldo() < monto) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        cuenta.setSaldo(cuenta.getSaldo() - monto);
    }
    public void actualizarCuenta(Cuenta cuentaExistente, Cuenta cuentaActualizada) {
        if (cuentaActualizada.getNumeroCuenta() != null && !cuentaActualizada.getNumeroCuenta().isEmpty()) {
            cuentaExistente.setNumeroCuenta(cuentaActualizada.getNumeroCuenta());
        }
        if (cuentaActualizada.getSaldo() >= 0) { // Verifica que el saldo sea válido
            cuentaExistente.setSaldo(cuentaActualizada.getSaldo());
        }
        if (cuentaActualizada.getTipoCuenta() != null && !cuentaActualizada.getTipoCuenta().isEmpty()) {
            cuentaExistente.setTipoCuenta(cuentaActualizada.getTipoCuenta());
        }
        // Agregar reglas de negocio adicionales aquí si es necesario
    }

}


