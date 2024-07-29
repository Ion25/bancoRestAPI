package com.banco.bancorestapi.application.ports.inbound;

import com.banco.bancorestapi.domain.entities.Cliente;

import java.util.List;

public interface ClienteService {
/*
    Optional<Cliente> obtenerClientePorId(Long id);
    List<Cliente> listarClientes();
    Cliente guardarCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    void eliminarCliente(Long id);

 */
    List<Cliente> listAll();
    Cliente listById(int id);
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(int id);
}
