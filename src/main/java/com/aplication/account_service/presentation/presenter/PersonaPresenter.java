package com.aplication.account_service.presentation.presenter;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "personaId")
@EqualsAndHashCode(of = "personaId")
@Builder
public class PersonaPresenter {
    private UUID personaId;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
