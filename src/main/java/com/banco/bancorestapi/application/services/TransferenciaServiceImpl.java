package com.banco.bancorestapi.application.services;

import com.banco.bancorestapi.application.ports.inbound.TransferenciaService;
import com.banco.bancorestapi.application.ports.outbound.CuentaRepository;
import com.banco.bancorestapi.application.ports.outbound.TransferenciaRespository;
import com.banco.bancorestapi.domain.entities.Cuenta;
import com.banco.bancorestapi.domain.entities.Transferencia;
import com.banco.bancorestapi.domain.service.GestionTransferencia;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private final TransferenciaRespository transferenciaRepository;
    private final CuentaRepository cuentaRepository;
    private final GestionTransferencia gestionTransferencia;

    public TransferenciaServiceImpl(TransferenciaRespository transferenciaRepository,
                                           CuentaRepository cuentaRepository,
                                           GestionTransferencia gestionTransferencia) {
        this.transferenciaRepository = transferenciaRepository;
        this.cuentaRepository = cuentaRepository;
        this.gestionTransferencia = gestionTransferencia;
    }

    @Override
    public Transferencia realizarTransferencia(Integer cuentaOrigenId, Integer cuentaDestinoId, double monto) {
        Cuenta cuentaOrigen = cuentaRepository.findById(cuentaOrigenId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de origen no encontrada"));
        Cuenta cuentaDestino = cuentaRepository.findById(cuentaDestinoId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta de destino no encontrada"));

        gestionTransferencia.realizarTransferencia(cuentaOrigen, cuentaDestino, monto);

        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);

        Transferencia transferencia = new Transferencia();
        transferencia.setCuentaOrigenId(cuentaOrigenId);
        transferencia.setCuentaDestinoId(cuentaDestinoId);
        transferencia.setMonto(monto);
        transferencia.setFecha(LocalDateTime.now());

        return transferenciaRepository.save(transferencia);
    }
}
