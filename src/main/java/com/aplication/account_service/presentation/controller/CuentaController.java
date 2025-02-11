package com.aplication.account_service.presentation.controller;

import com.aplication.account_service.presentation.presenter.CuentaPresenter;
import com.aplication.account_service.service.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CuentaController {
    @Autowired
    private final CuentaService cuentaService;

    @GetMapping("/cuentas")
    public List<CuentaPresenter> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }
}
