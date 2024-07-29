package com.banco.bancorestapi.infrastructure.adapters.inbound.rest;

import com.banco.bancorestapi.application.ports.inbound.ClienteService;
import com.banco.bancorestapi.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /*
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<?> listById(@PathVariable int id) {
        Cliente cliente = clienteService.listById(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll() {
        List<Cliente> clientes = clienteService.listAll();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizerCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        Cliente clienteActualizado = clienteService.update(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.create(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        clienteService.delete(id);
        return ResponseEntity.ok(null);
    }
}
