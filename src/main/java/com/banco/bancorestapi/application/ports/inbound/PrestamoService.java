package com.banco.bancorestapi.application.ports.inbound;

import com.banco.bancorestapi.domain.entities.Prestamo;

import java.time.LocalDateTime;

public interface PrestamoService {

    Prestamo solicitarPrestamo(Integer clienteId, double monto, double tasaInteres, LocalDateTime fechaFin);

}
