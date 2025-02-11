package com.aplication.account_service.service;

import com.aplication.account_service.entity.Cuenta;
import com.aplication.account_service.entity.Movimiento;
import com.aplication.account_service.presentation.presenter.CuentaPresenter;
import com.aplication.account_service.presentation.presenter.MovimientoPresenter;

import java.util.List;
import java.util.UUID;

public interface MovimientoService {
    public List<MovimientoPresenter> getAllMovimientos();

    MovimientoPresenter createMovimiento(Movimiento movimiento);

    MovimientoPresenter updateMovimiento(Movimiento movimiento);

    void deleteMovimiento(UUID movimientoId);
}
