package com.banco.bancorestapi.application.ports.inbound;

import com.banco.bancorestapi.domain.entities.TarjetaCredito;

import java.time.LocalDateTime;

public interface TarjetaCreditoService {

    TarjetaCredito solicitarTarjetaDeCredito(Integer clienteId, String numeroTarjeta,
                                             double limiteCredito, LocalDateTime fechaExpiracion);

}
