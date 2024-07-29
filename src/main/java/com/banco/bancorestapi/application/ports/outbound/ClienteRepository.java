package com.banco.bancorestapi.application.ports.outbound;

import com.banco.bancorestapi.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
/*
    Optional<Cliente> obtenerClientePorId(Long id);
    List<Cliente> listarClientes();
    Cliente guardarCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);
 */
}
