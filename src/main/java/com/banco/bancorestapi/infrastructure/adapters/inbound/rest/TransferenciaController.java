package com.banco.bancorestapi.infrastructure.adapters.inbound.rest;

import com.banco.bancorestapi.application.ports.inbound.TransferenciaService;
import com.banco.bancorestapi.domain.entities.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<Transferencia> realizarTransferencia(@RequestBody Transferencia transferencia) {
        Transferencia transferenciaRealizada = transferenciaService.realizarTransferencia(
                                                transferencia.getCuentaOrigenId(),
                                                transferencia.getCuentaDestinoId(),
                                                transferencia.getMonto());
        return new ResponseEntity<>(transferencia, HttpStatus.CREATED);
    }

}

