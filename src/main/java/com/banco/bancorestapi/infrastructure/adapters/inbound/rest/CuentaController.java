package com.banco.bancorestapi.infrastructure.adapters.inbound.rest;

import com.banco.bancorestapi.application.ports.inbound.CuentaService;
import com.banco.bancorestapi.domain.entities.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> listarCuentas() {
        List<Cuenta> cuentas = cuentaService.listarCuentas();
        return ResponseEntity.ok(cuentas);
    }

    @PostMapping
    public ResponseEntity<Cuenta> abrirCuenta(@RequestBody Cuenta cuenta, @RequestParam double saldoInicial) {
        Cuenta cuentaAbierta = cuentaService.abrirCuenta(cuenta, saldoInicial);
        return ResponseEntity.ok(cuentaAbierta);
    }

    @PostMapping("/{cuentaId}/depositar")
    public ResponseEntity<Cuenta> depositarCuenta(@PathVariable Integer cuentaId, @RequestParam double monto) {
        Cuenta cuentaDepositada = cuentaService.depositar(cuentaId, monto);
        return ResponseEntity.ok(cuentaDepositada);
    }

    @PostMapping("/{cuentaId}/retirar")
    public ResponseEntity<Cuenta> retirarMonto(@PathVariable Integer cuentaId, @RequestParam double monto) {
        Cuenta cuentaRetirada = cuentaService.retirar(cuentaId, monto);
        return ResponseEntity.ok(cuentaRetirada);
    }

    // Otros métodos CRUD
}