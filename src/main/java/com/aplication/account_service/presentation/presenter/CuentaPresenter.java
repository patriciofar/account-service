package com.aplication.account_service.presentation.presenter;

import com.aplication.account_service.entity.Cliente;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@ToString(of = "cuentaId")
@EqualsAndHashCode(of = "cuentaId")
@Builder
public class CuentaPresenter {
    private UUID cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private Boolean estado;
    private Cliente cliente;
}
