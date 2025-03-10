package com.banco.bancorestapi.application.services;

import com.banco.bancorestapi.application.ports.inbound.ClienteService;
import com.banco.bancorestapi.application.ports.outbound.ClienteRepository;
import com.banco.bancorestapi.domain.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente listById(int id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(int id) {
        clienteRepository.deleteById(id);
    }


/*
    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepositorio.obtenerClientePorId(id);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.listarClientes();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.guardarCliente(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepositorio.actualizarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepositorio.eliminarCliente(id);
    }

 */
}
