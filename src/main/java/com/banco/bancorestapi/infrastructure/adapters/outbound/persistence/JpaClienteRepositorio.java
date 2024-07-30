/*
package com.banco.bancorestapi.infrastructure.adapters.outbound.persistence;

import com.banco.bancorestapi.application.ports.outbound.ClienteRepositorio;
import com.banco.bancorestapi.domain.entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JpaClienteRepositorio implements ClienteRepositorio {

    private Map<Long, Cliente> database = new HashMap<>();

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public List<Cliente> listarClientes() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        database.put(cliente.getId(), cliente);
        return cliente;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        database.put(cliente.getId(), cliente);
        return cliente;
    }

    @Override
    public void eliminarCliente(Long id) {
        database.remove(id);
    }
}
*/