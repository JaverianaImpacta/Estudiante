package edu.javeriana.ingenieria.estudiantes.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="id_institucional")
    private Long idInstitucional;

    @Column(name="correo_institucional")
    private String correoInstitucional;

    private Long cedula;

    private Integer semestre;

    private boolean arl;

    @Column(name="sentido_mi_practica")
    private boolean sentidoMiPractica;
}
