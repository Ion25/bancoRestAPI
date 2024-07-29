package com.banco.bancorestapi.application.ports.outbound;

import com.banco.bancorestapi.domain.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}