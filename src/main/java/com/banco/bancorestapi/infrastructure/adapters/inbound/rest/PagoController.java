package com.banco.bancorestapi.infrastructure.adapters.inbound.rest;

import com.banco.bancorestapi.application.ports.inbound.PagoService;
import com.banco.bancorestapi.domain.entities.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping
    public ResponseEntity<Pago> realizarPago(@RequestBody Pago pago) {
        Pago pagoRealizado = pagoService.realizarPago(
                pago.getCuentaId(), pago.getProveedor(), pago.getMonto());
        return new ResponseEntity<>(pagoRealizado, HttpStatus.CREATED);
    }

}