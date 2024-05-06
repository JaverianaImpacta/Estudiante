package edu.javeriana.ingenieria.estudiantes.servicio;

import edu.javeriana.ingenieria.estudiantes.dominio.Estudiante;
import edu.javeriana.ingenieria.estudiantes.repositorio.RepositorioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEstudiante {
    @Autowired
    private RepositorioEstudiante repositorio;

    public List<Estudiante> obtenerEstudiantes(){
        return repositorio.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Integer id) {
        return repositorio.findOneById(id);
    }

    public Estudiante obtenerEstudiantePorCedula(Integer cedula) {
        return repositorio.findOneByCedula(cedula);
    }
}
