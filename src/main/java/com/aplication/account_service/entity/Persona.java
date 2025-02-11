package com.aplication.account_service.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@Getter
public class Persona {
    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}