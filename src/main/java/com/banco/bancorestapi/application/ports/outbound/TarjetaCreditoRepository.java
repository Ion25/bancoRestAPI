package com.banco.bancorestapi.application.ports.outbound;

import com.banco.bancorestapi.domain.entities.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Integer> {
}
