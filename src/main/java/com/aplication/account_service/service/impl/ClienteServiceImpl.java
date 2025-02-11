package com.aplication.account_service.service.impl;

import com.aplication.account_service.entity.Cliente;
import com.aplication.account_service.presentation.presenter.ClientePresenter;
import com.aplication.account_service.repository.ClienteRepository;
import com.aplication.account_service.service.ClienteService;
import liquibase.repackaged.net.sf.jsqlparser.util.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClientePresenter> getAllClientes() {
        List<Cliente> allClientes = clienteRepository.findAll();
        List<ClientePresenter> allClientesPresenter = allClientes.stream()
                .map(this::buildClientePresenter)
                .collect(Collectors.toList());
        return allClientesPresenter;
    }
    @Override
    public ClientePresenter createCliente(Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        return buildClientePresenter(savedCliente);
    }

    @Override
    public ClientePresenter updateCliente(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getClienteId())) {
            return buildClientePresenter(clienteRepository.save(cliente));
        } else {
            throw new ValidationException("Cliente no encontrado con ID: " + cliente.getClienteId());
        }
    }

    @Override
    public void deleteCliente(UUID clienteId) {
        if (clienteRepository.existsById(clienteId)) {
            clienteRepository.deleteById(clienteId);
        } else {
            throw new ValidationException("Cliente no encontrado con ID: " + clienteId);
        }
    }

    private ClientePresenter buildClientePresenter(Cliente cliente) {
        return ClientePresenter.builder()
                .clienteId(cliente.getClienteId())
                .contrasena(cliente.getContrasena())
                .estado(cliente.isEstado())
                .nombre(cliente.getNombre())
                .genero(cliente.getGenero())
                .edad(cliente.getEdad())
                .identificacion(cliente.getIdentificacion())
                .direccion(cliente.getDireccion())
                .telefono(cliente.getTelefono())
                .build();
    }
}
