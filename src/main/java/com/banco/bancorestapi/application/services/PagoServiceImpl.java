package com.banco.bancorestapi.application.services;

import com.banco.bancorestapi.application.ports.inbound.PagoService;
import com.banco.bancorestapi.application.ports.outbound.CuentaRepository;
import com.banco.bancorestapi.application.ports.outbound.PagoRepository;
import com.banco.bancorestapi.domain.entities.Cuenta;
import com.banco.bancorestapi.domain.entities.Pago;
import com.banco.bancorestapi.domain.service.GestionPago;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;
    private final CuentaRepository cuentaRepository;
    private final GestionPago gestionPago;

    public PagoServiceImpl(PagoRepository pagoRepository, CuentaRepository cuentaRepository, GestionPago gestionPago) {
        this.pagoRepository = pagoRepository;
        this.cuentaRepository = cuentaRepository;
        this.gestionPago = gestionPago;
    }

    @Override
    public Pago realizarPago(Integer cuentaId, String proveedor, double monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));

        Pago pago = new Pago();
        pago.setCuentaId(cuentaId);
        pago.setProveedor(proveedor);
        pago.setMonto(monto);
        pago.setFecha(LocalDateTime.now());

        gestionPago.procesarPago(cuenta, pago);

        cuentaRepository.save(cuenta);
        return pagoRepository.save(pago);
    }
}
