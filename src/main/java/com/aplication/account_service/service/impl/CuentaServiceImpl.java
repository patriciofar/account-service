package com.aplication.account_service.service.impl;

import com.aplication.account_service.entity.Cuenta;
import com.aplication.account_service.presentation.presenter.CuentaPresenter;
import com.aplication.account_service.repository.CuentaRepository;
import com.aplication.account_service.service.CuentaService;
import liquibase.repackaged.net.sf.jsqlparser.util.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {
    private final CuentaRepository cuentaRepository;

    @Override
    public List<CuentaPresenter> getAllCuentas() {
        List<Cuenta> allCuentas = cuentaRepository.findAll();

        List<CuentaPresenter> allCuentasPresenter = allCuentas.stream()
                .map(this::buildCuentaPresenter)
                .collect(Collectors.toList());
        return allCuentasPresenter;
    }

    @Override
    public CuentaPresenter createCuenta(Cuenta cuenta) {
        Cuenta savedCuenta = cuentaRepository.save(cuenta);
        return buildCuentaPresenter(savedCuenta);
    }

    @Override
    public CuentaPresenter updateCuenta(Cuenta cuenta) {
        if (cuentaRepository.existsById(cuenta.getCuentaId())) {
            return buildCuentaPresenter(cuentaRepository.save(cuenta));
        } else {
            throw new ValidationException("Cuenta no encontrado con ID: " + cuenta.getCuentaId());
        }
    }

    @Override
    public void deleteCuenta(UUID cuentaId) {
        if (cuentaRepository.existsById(cuentaId)) {
            cuentaRepository.deleteById(cuentaId);
        } else {
            throw new ValidationException("Cuenta no encontrado con ID: " + cuentaId);
        }
    }


    private CuentaPresenter buildCuentaPresenter(Cuenta cuenta) {
        return CuentaPresenter.builder()
                .cuentaId(cuenta.getCuentaId())
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .saldoInicial(cuenta.getSaldoInicial())
                .estado(cuenta.isEstado())
                .cliente(cuenta.getCliente())
                .build();
    }
}
