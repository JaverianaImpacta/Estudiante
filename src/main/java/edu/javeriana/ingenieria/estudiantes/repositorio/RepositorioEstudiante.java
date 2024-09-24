package edu.javeriana.ingenieria.estudiantes.repositorio;

import edu.javeriana.ingenieria.estudiantes.dominio.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante, Integer> {
    Estudiante findOneByCedula(Long cedula);

    boolean existsByCedula(Long cedula);

    List<Estudiante> findAllByArl(boolean arl);

    List<Estudiante> findAllBySentidoMiPractica(boolean sentidoMiPractica);

    Estudiante findOneByIdInstitucional(Long idInstitucional);

    boolean existsByIdInstitucional(Long idInstitucional);

    boolean existsByCorreoInstitucional(String correoInstitucional);

    Estudiante findOneByCorreoInstitucional(String correoInstitucional);
}
