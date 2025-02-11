package com.aplication.account_service.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@ToString(of = "cuentaId")
@Table(name = "cuentas")
@NoArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue
    private UUID cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    @Column(precision = 16, scale = 6)
    private BigDecimal saldoInicial;
    private boolean estado;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}