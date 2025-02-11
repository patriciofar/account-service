package com.aplication.account_service.presentation.controller;

import com.aplication.account_service.entity.Cliente;
import com.aplication.account_service.presentation.presenter.ClientePresenter;
import com.aplication.account_service.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    @GetMapping("/clientes")
    public List<ClientePresenter> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @PostMapping("/save-cliente")
    public ResponseEntity<ClientePresenter> createCliente(@RequestBody Cliente cliente) {
        ClientePresenter createdCliente = clienteService.createCliente(cliente);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping("/update-cliente/{clienteId}")
    public ResponseEntity<ClientePresenter> updateCliente(@PathVariable UUID clienteId, @RequestBody Cliente cliente) {
        if (!clienteId.equals(cliente.getClienteId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ClientePresenter updatedCliente = clienteService.updateCliente(cliente);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    @DeleteMapping("/delete-cliente/{clienteId}")
    public ResponseEntity<Void> deleteCliente(@PathVariable UUID clienteId) {
        try {
            clienteService.deleteCliente(clienteId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}