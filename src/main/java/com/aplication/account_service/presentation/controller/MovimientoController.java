package com.aplication.account_service.presentation.controller;

import com.aplication.account_service.entity.Movimiento;
import com.aplication.account_service.presentation.presenter.MovimientoPresenter;
import com.aplication.account_service.service.MovimientoService;
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
public class MovimientoController {
    @Autowired
    private final MovimientoService movimientoService;

    @GetMapping("/movimientos")
    public List<MovimientoPresenter> getAllMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @PostMapping("/save-movimiento")
    public ResponseEntity<MovimientoPresenter> createMovimiento(@RequestBody Movimiento movimiento) {
        MovimientoPresenter createdMovimiento = movimientoService.createMovimiento(movimiento);
        return new ResponseEntity<>(createdMovimiento, HttpStatus.CREATED);
    }

    @PutMapping("/update-movimiento/{movimientoId}")
    public ResponseEntity<MovimientoPresenter> updateMovimiento(@PathVariable UUID movimientoId, @RequestBody Movimiento movimiento) {
        if (!movimientoId.equals(movimiento.getMovimientoId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MovimientoPresenter updatedMovimiento = movimientoService.updateMovimiento(movimiento);
        return new ResponseEntity<>(updatedMovimiento, HttpStatus.OK);
    }

    @DeleteMapping("/delete-movimiento/{movimientoId}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable UUID movimientoId) {
        try {
            movimientoService.deleteMovimiento(movimientoId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
