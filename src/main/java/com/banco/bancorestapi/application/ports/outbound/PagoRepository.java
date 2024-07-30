package com.banco.bancorestapi.application.ports.outbound;

import com.banco.bancorestapi.domain.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
