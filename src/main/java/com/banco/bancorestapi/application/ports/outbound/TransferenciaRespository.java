package com.banco.bancorestapi.application.ports.outbound;

import com.banco.bancorestapi.domain.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRespository extends JpaRepository<Transferencia, Integer> {
}
