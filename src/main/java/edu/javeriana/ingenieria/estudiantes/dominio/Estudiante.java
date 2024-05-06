package edu.javeriana.ingenieria.estudiantes.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Estudiante {
    @Id
    private Integer id;
    private Integer id_institucional, cedula, semestre;
    private String correo_institucional;
    private boolean arl, sentido_mi_practica;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_institucional() {
        return id_institucional;
    }

    public void setId_institucional(Integer id_institucional) {
        this.id_institucional = id_institucional;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getCorreo_institucional() {
        return correo_institucional;
    }

    public void setCorreo_institucional(String correo_institucional) {
        this.correo_institucional = correo_institucional;
    }

    public boolean isArl() {
        return arl;
    }

    public void setArl(boolean arl) {
        this.arl = arl;
    }

    public boolean isSentido_mi_practica() {
        return sentido_mi_practica;
    }

    public void setSentido_mi_practica(boolean sentido_mi_practica) {
        this.sentido_mi_practica = sentido_mi_practica;
    }
}
