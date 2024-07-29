package com.banco.bancorestapi.infrastructure.adapters.inbound.rest;

import com.banco.bancorestapi.application.ports.inbound.TarjetaCreditoService;
import com.banco.bancorestapi.domain.entities.TarjetaCredito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaCreditoController {

    @Autowired
    private TarjetaCreditoService tarjetaCreditoService;

    @PostMapping
    public ResponseEntity<TarjetaCredito> solicitarTarjeta(@RequestBody TarjetaCredito tarjetaCredito) {
        TarjetaCredito tarjeta = tarjetaCreditoService.solicitarTarjetaDeCredito(
                tarjetaCredito.getClienteId(), tarjetaCredito.getNumeroTarjeta(),
                tarjetaCredito.getLimiteCredito(), tarjetaCredito.getFechaExpiracion());
        return new ResponseEntity<>(tarjeta, HttpStatus.CREATED);
    }

}
