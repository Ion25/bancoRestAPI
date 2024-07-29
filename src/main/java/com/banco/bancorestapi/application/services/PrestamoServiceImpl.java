package com.banco.bancorestapi.application.services;

import com.banco.bancorestapi.application.ports.inbound.PrestamoService;
import com.banco.bancorestapi.application.ports.outbound.ClienteRepository;
import com.banco.bancorestapi.application.ports.outbound.PrestamoRepository;
import com.banco.bancorestapi.domain.entities.Cliente;
import com.banco.bancorestapi.domain.entities.Prestamo;
import com.banco.bancorestapi.domain.otherDomain.valueObjects.EstadoPrestamo;
import com.banco.bancorestapi.domain.service.GestionPrestamo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final ClienteRepository clienteRepository;
    private final GestionPrestamo gestionPrestamo;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository, ClienteRepository clienteRepository, GestionPrestamo gestionPrestamo) {
        this.prestamoRepository = prestamoRepository;
        this.clienteRepository = clienteRepository;
        this.gestionPrestamo = gestionPrestamo;
    }

    @Override
    public Prestamo solicitarPrestamo(Integer clienteId, double monto, double tasaInteres, LocalDateTime fechaFin) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        Prestamo prestamo = new Prestamo();
        prestamo.setClienteId(clienteId);
        prestamo.setMonto(monto);
        prestamo.setTasaInteres(tasaInteres);
        prestamo.setFechaInicio(LocalDateTime.now());
        prestamo.setFechaFin(fechaFin);
        prestamo.setEstado(EstadoPrestamo.PENDIENTE);

        gestionPrestamo.evaluarPrestamo(cliente, prestamo);

        return prestamoRepository.save(prestamo);
    }
}
