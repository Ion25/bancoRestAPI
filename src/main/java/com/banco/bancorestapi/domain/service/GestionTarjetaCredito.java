package com.banco.bancorestapi.domain.service;

import com.banco.bancorestapi.domain.entities.Cliente;
import com.banco.bancorestapi.domain.entities.TarjetaCredito;
import com.banco.bancorestapi.domain.otherDomain.valueObjects.EstadoTarjeta;
import org.springframework.stereotype.Service;

@Service
public class GestionTarjetaCredito {

    public void evaluarSolicitudTarjeta(Cliente cliente, TarjetaCredito tarjeta) {
        // Lógica de negocio para evaluar la solicitud de tarjeta de crédito
        if (cliente.getScoreCredito() > 650) {
            tarjeta.setEstado(EstadoTarjeta.ACTIVA);
        } else {
            tarjeta.setEstado(EstadoTarjeta.BLOQUEADA);
        }
    }

}