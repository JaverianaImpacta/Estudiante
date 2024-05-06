package edu.javeriana.ingenieria.estudiantes.repositorio;

import edu.javeriana.ingenieria.estudiantes.dominio.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante, Integer> {
    Estudiante findOneById(Integer id);

    Estudiante findOneByCedula(Integer cedula);
}
