package com.aplication.account_service.presentation.presenter;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "clienteId")
@EqualsAndHashCode(of = "clienteId")
@Builder
public class ClientePresenter {
    private UUID clienteId;
    private String contrasena;
    private boolean estado;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}