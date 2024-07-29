package com.banco.bancorestapi.application.ports.inbound;

import com.banco.bancorestapi.domain.entities.Cuenta;

import java.util.List;

public interface CuentaService {

    List<Cuenta> listarCuentas();
    Cuenta abrirCuenta(Cuenta cuenta, double saldoInicial);
    Cuenta depositar(Integer cuentaId, double monto);
    Cuenta retirar(Integer cuentaId, double monto);
}
