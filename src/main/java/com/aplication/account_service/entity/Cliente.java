package com.aplication.account_service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@ToString(of = "clienteId")
@Table(name = "clientes")
@NoArgsConstructor
public class Cliente extends Persona {
    @Id
    @GeneratedValue
    private UUID clienteId;
    private String contrasena;
    private boolean estado;
}