package com.aplication.account_service.service;

import com.aplication.account_service.entity.Cliente;
import com.aplication.account_service.presentation.presenter.ClientePresenter;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<ClientePresenter> getAllClientes();
    ClientePresenter createCliente(Cliente cliente);
    ClientePresenter updateCliente(Cliente cliente);
    void deleteCliente(UUID clienteId);
}
