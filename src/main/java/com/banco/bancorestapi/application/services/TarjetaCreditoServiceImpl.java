package com.banco.bancorestapi.application.services;

import com.banco.bancorestapi.application.ports.inbound.TarjetaCreditoService;
import com.banco.bancorestapi.application.ports.outbound.ClienteRepository;
import com.banco.bancorestapi.application.ports.outbound.TarjetaCreditoRepository;
import com.banco.bancorestapi.domain.entities.Cliente;
import com.banco.bancorestapi.domain.entities.TarjetaCredito;
import com.banco.bancorestapi.domain.otherDomain.valueObjects.EstadoTarjeta;
import com.banco.bancorestapi.domain.service.GestionTarjetaCredito;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class TarjetaCreditoServiceImpl implements TarjetaCreditoService {
    private final TarjetaCreditoRepository tarjetaCreditoRepository;
    private final ClienteRepository clienteRepository;
    private final GestionTarjetaCredito gestionTarjetaDeCredito;

    public TarjetaCreditoServiceImpl(TarjetaCreditoRepository tarjetaCreditoRepository, ClienteRepository clienteRepository, GestionTarjetaCredito gestionTarjetaDeCredito) {
        this.tarjetaCreditoRepository = tarjetaCreditoRepository;
        this.clienteRepository = clienteRepository;
        this.gestionTarjetaDeCredito = gestionTarjetaDeCredito;
    }

    @Override
    public TarjetaCredito solicitarTarjetaDeCredito(Integer clienteId, String numeroTarjeta, double limiteCredito, LocalDateTime fechaExpiracion) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        TarjetaCredito tarjeta = new TarjetaCredito();
        tarjeta.setClienteId(clienteId);
        tarjeta.setNumeroTarjeta(numeroTarjeta);
        tarjeta.setLimiteCredito(limiteCredito);
        tarjeta.setSaldo(0.0);
        tarjeta.setFechaExpiracion(fechaExpiracion);
        tarjeta.setEstado(EstadoTarjeta.ACTIVA);

        gestionTarjetaDeCredito.evaluarSolicitudTarjeta(cliente, tarjeta);

        return tarjetaCreditoRepository.save(tarjeta);
    }
}
