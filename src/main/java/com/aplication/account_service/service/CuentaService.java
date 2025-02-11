package com.aplication.account_service.service;

import com.aplication.account_service.presentation.presenter.CuentaPresenter;

import java.util.List;

public interface CuentaService {

    List<CuentaPresenter> getAllCuentas();
}
