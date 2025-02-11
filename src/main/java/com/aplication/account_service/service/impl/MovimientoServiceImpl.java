package com.aplication.account_service.service.impl;

import com.aplication.account_service.entity.Cliente;
import com.aplication.account_service.entity.Cuenta;
import com.aplication.account_service.entity.Movimiento;
import com.aplication.account_service.presentation.presenter.ClientePresenter;
import com.aplication.account_service.presentation.presenter.CuentaPresenter;
import com.aplication.account_service.presentation.presenter.MovimientoPresenter;
import com.aplication.account_service.repository.CuentaRepository;
import com.aplication.account_service.repository.MovimientoRepository;
import com.aplication.account_service.service.MovimientoService;
import liquibase.repackaged.net.sf.jsqlparser.util.validation.ValidationException;
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
    private final CuentaRepository cuentaRepository;

    @Override
    public List<MovimientoPresenter> getAllMovimientos() {
        List<Movimiento> allMovimientos = movimientoRepository.findAll();

        List<MovimientoPresenter> allMovimientosPresenter = allMovimientos.stream()
                .map(this::buildMovimientoPresenter)
                .collect(Collectors.toList());
        return allMovimientosPresenter;
    }

    @Override
    public MovimientoPresenter createMovimiento(Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(movimiento.getCuenta().getCuentaId())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        if (movimiento.getTipoMovimiento().equals("DEBITO")) {
            if (cuenta.getSaldoInicial().compareTo(movimiento.getValor()) < 0) {
                throw new RuntimeException("Saldo no disponible");
            }
            cuenta.setSaldoInicial(cuenta.getSaldoInicial().subtract(movimiento.getValor()));
        } else if (movimiento.getTipoMovimiento().equals("CREDITO")) {
            cuenta.setSaldoInicial(cuenta.getSaldoInicial().add(movimiento.getValor()));
        } else {
            throw new RuntimeException("Tipo de movimiento no válido");
        }
        movimiento.setSaldo(cuenta.getSaldoInicial());

        Movimiento savedMovimiento = movimientoRepository.save(movimiento);
        cuentaRepository.save(cuenta);
        return buildMovimientoPresenter(savedMovimiento);
    }

    @Override
    public MovimientoPresenter updateMovimiento(Movimiento movimiento) {
        if (movimientoRepository.existsById(movimiento.getMovimientoId())) {
            return buildMovimientoPresenter(movimientoRepository.save(movimiento));
        } else {
            throw new ValidationException("Movimiento no encontrado con ID: " + movimiento.getMovimientoId());
        }
    }

    @Override
    public void deleteMovimiento(UUID movimientoId) {
        if (movimientoRepository.existsById(movimientoId)) {
            movimientoRepository.deleteById(movimientoId);
        } else {
            throw new ValidationException("Movimiento no encontrado con ID: " + movimientoId);
        }
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
