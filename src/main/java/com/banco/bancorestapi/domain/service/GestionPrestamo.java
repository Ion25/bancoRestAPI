package com.banco.bancorestapi.domain.service;

import com.banco.bancorestapi.domain.entities.Cliente;
import com.banco.bancorestapi.domain.entities.Prestamo;
import com.banco.bancorestapi.domain.otherDomain.valueObjects.EstadoPrestamo;
import org.springframework.stereotype.Service;

@Service
public class GestionPrestamo {
    public void evaluarPrestamo(Cliente cliente, Prestamo prestamo) {
        // Lógica de negocio para evaluar el préstamo, por ejemplo, verificar la capacidad de pago del cliente
        if (cliente.getScoreCredito() > 700) {
            prestamo.setEstado(EstadoPrestamo.APROBADO);
        } else {
            prestamo.setEstado(EstadoPrestamo.RECHAZADO);
        }
    }
}
