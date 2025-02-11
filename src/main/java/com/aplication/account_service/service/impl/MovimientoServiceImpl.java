package com.aplication.account_service.service.impl;

import com.aplication.account_service.entity.Cuenta;
import com.aplication.account_service.entity.Movimiento;
import com.aplication.account_service.presentation.presenter.CuentaPresenter;
import com.aplication.account_service.presentation.presenter.MovimientoPresenter;
import com.aplication.account_service.repository.MovimientoRepository;
import com.aplication.account_service.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {
    private final MovimientoRepository movimientoRepository;

    @Override
    public List<MovimientoPresenter> getAllMovimientos() {
        List<Movimiento> allMovimientos = movimientoRepository.findAll();

        List<MovimientoPresenter> allMovimientosPresenter = allMovimientos.stream()
                .map(this::buildMovimientoPresenter)
                .collect(Collectors.toList());
        return allMovimientosPresenter;
    }

    private MovimientoPresenter buildMovimientoPresenter(Movimiento movimiento) {
        return MovimientoPresenter.builder()
                .movimientoId(movimiento.getMovimientoId())
                .fecha(movimiento.getFecha())
                .tipoMovimiento(movimiento.getTipoMovimiento())
                .valor(movimiento.getValor())
                .saldo(movimiento.getSaldo())
                .cuenta(movimiento.getCuenta())
                .build();
    }
}
