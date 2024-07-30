package com.banco.bancorestapi.infrastructure.adapters.inbound.rest;

import com.banco.bancorestapi.application.ports.inbound.PrestamoService;
import com.banco.bancorestapi.domain.entities.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public ResponseEntity<Prestamo> solicitarPrestamo(@RequestBody Prestamo prestamos) {
        Prestamo prestamo = prestamoService.solicitarPrestamo(
                prestamos.getClienteId(), prestamos.getMonto(), prestamos.getTasaInteres(), prestamos.getFechaFin());
        return new ResponseEntity<>(prestamo, HttpStatus.CREATED);
    }

}
