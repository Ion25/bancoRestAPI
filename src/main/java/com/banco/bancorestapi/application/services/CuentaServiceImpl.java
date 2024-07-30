package com.banco.bancorestapi.application.services;

import com.banco.bancorestapi.application.ports.inbound.CuentaService;
import com.banco.bancorestapi.application.ports.outbound.CuentaRepository;
import com.banco.bancorestapi.domain.entities.Cuenta;
import com.banco.bancorestapi.domain.otherDomain.valueObjects.SaldoInicial;
import com.banco.bancorestapi.domain.service.GestionCuenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final GestionCuenta gestionCuenta;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, GestionCuenta gestionCuenta) {
        this.cuentaRepository = cuentaRepository;
        this.gestionCuenta = gestionCuenta;
    }

    @Override
    public List<Cuenta> listarCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta abrirCuenta(Cuenta cuenta, double saldoInicial) {
        gestionCuenta.abrirCuenta(cuenta, new SaldoInicial(saldoInicial));
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta depositar(Integer cuentaId, double monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        gestionCuenta.depositar(cuenta, monto);
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta retirar(Integer cuentaId, double monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        gestionCuenta.retirar(cuenta, monto);
        return cuentaRepository.save(cuenta);
    }
    @Override
    public Cuenta actualizarCuenta(Integer cuentaId, Cuenta cuentaActualizada) {
        Cuenta cuentaExistente = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        gestionCuenta.actualizarCuenta(cuentaExistente, cuentaActualizada);
        return cuentaRepository.save(cuentaExistente);
    }
    @Override
    public void eliminarCuenta(Integer cuentaId) {
        if (cuentaRepository.existsById(cuentaId)) {
            cuentaRepository.deleteById(cuentaId);
        } else {
            throw new IllegalArgumentException("Cuenta no encontrada");
        }
    }

    // Otros métodos CRUD
}

