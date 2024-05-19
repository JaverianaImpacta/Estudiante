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

    public List<Estudiante> obtenerEstudiantes(boolean sentidoMiPractica){
        return repositorio.findAllBySentidoMiPractica(sentidoMiPractica);
    }

    public List<Estudiante> obtenerEstudiantesPorARL(boolean arl){
        return repositorio.findAllByArl(arl);
    }

    public Estudiante obtenerEstudiante(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public Estudiante obtenerEstudiante(String correoInstitucional){
        return repositorio.findOneByCorreoInstitucional(correoInstitucional);
    }


    public Estudiante obtenerEstudiantePorCedula(Integer cedula) {
        return repositorio.findOneByCedula(cedula);
    }

    public Estudiante obtenerEstudiantePorIdInstitucional(Integer idInstitucional) {
        return repositorio.findOneByIdInstitucional(idInstitucional);
    }

    public Estudiante actualizarEstudiante(Integer id, Estudiante estudiante) {
        if(repositorio.findById(id).orElse(null) == null){
            return null;
        }
        estudiante.setId(id);
        return repositorio.save(estudiante);
    }

    public boolean estudianteExiste(Integer id){
        return repositorio.existsById(id);
    }

    public boolean estudianteExiste(String correoInstitucional){
        return repositorio.existsByCorreoInstitucional(correoInstitucional);
    }

    public boolean estudianteExistePorCedula(Integer cedula){
        return repositorio.existsByCedula(cedula);
    }

    public boolean estudianteExistePorIdInstitucional(Integer idInstitucional) {
        return repositorio.existsByIdInstitucional(idInstitucional);
    }
}
