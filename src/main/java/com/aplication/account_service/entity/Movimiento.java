package com.aplication.account_service.entity;

import com.aplication.account_service.entity.Cuenta;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@ToString(of = "movimientoId")
@Table(name = "movimientos")
@NoArgsConstructor
public class Movimiento {
    @Id
    @GeneratedValue
    private UUID movimientoId;
    private Date fecha;
    private String tipoMovimiento;
    @Column(precision = 16, scale = 6)
    private BigDecimal valor;
    @Column(precision = 16, scale = 6)
    private BigDecimal saldo;
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;
}