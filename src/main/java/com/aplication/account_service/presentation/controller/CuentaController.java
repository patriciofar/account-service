package com.aplication.account_service.presentation.controller;

import com.aplication.account_service.entity.Cuenta;
import com.aplication.account_service.presentation.presenter.CuentaPresenter;
import com.aplication.account_service.service.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CuentaController {
    @Autowired
    private final CuentaService cuentaService;

    @GetMapping("/cuentas")
    public List<CuentaPresenter> getAllCuentas() {
        return cuentaService.getAllCuentas();
    }

    @PostMapping("/save-cuenta")
    public ResponseEntity<CuentaPresenter> createCuenta(@RequestBody Cuenta cuenta) {
        CuentaPresenter createdCuenta = cuentaService.createCuenta(cuenta);
        return new ResponseEntity<>(createdCuenta, HttpStatus.CREATED);
    }

    @PutMapping("/update-cuenta/{cuentaId}")
    public ResponseEntity<CuentaPresenter> updateCliente(@PathVariable UUID cuentaId, @RequestBody Cuenta cuenta) {
        if (!cuentaId.equals(cuenta.getCuentaId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CuentaPresenter updatedCliente = cuentaService.updateCuenta(cuenta);
        return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
    }

    @DeleteMapping("/delete-cuenta/{cuentaId}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable UUID cuentaId) {
        try {
            cuentaService.deleteCuenta(cuentaId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
