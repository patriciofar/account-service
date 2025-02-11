package com.aplication.account_service.service;

import com.aplication.account_service.entity.Cuenta;
import com.aplication.account_service.presentation.presenter.CuentaPresenter;

import java.util.List;
import java.util.UUID;

public interface CuentaService {

    List<CuentaPresenter> getAllCuentas();

    CuentaPresenter createCuenta(Cuenta cuenta);

    CuentaPresenter updateCuenta(Cuenta cuenta);

    void deleteCuenta(UUID cuentaId);
}
