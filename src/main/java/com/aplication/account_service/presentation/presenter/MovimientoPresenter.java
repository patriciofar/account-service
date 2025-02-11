package com.aplication.account_service.presentation.presenter;

import com.aplication.account_service.entity.Cuenta;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString(of = "movimientoId")
@EqualsAndHashCode(of = "movimientoId")
@Builder
public class MovimientoPresenter {
    private UUID movimientoId;
    private Date fecha;
    private String tipoMovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;
    private Cuenta cuenta;
}
