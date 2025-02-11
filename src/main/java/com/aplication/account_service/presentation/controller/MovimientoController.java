package com.aplication.account_service.presentation.controller;

import com.aplication.account_service.presentation.presenter.CuentaPresenter;
import com.aplication.account_service.presentation.presenter.MovimientoPresenter;
import com.aplication.account_service.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovimientoController {
    @Autowired
    private final MovimientoService movimientoService;

    @GetMapping("/movimientos")
    public List<MovimientoPresenter> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }
}
