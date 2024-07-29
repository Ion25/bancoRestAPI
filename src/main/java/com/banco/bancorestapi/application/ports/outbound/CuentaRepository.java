package com.banco.bancorestapi.application.ports.outbound;

import com.banco.bancorestapi.domain.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}