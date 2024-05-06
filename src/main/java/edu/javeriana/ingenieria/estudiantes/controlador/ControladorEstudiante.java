package edu.javeriana.ingenieria.estudiantes.controlador;

import edu.javeriana.ingenieria.estudiantes.dominio.Estudiante;
import edu.javeriana.ingenieria.estudiantes.servicio.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorEstudiante {
    @Autowired
    private ServicioEstudiante servicio;


    @GetMapping("listar")
    public List<Estudiante> obtenerEstudiantes(){
        return servicio.obtenerEstudiantes();
    }

    @GetMapping("obtenerId")
    public Estudiante obtenerEstudiantePorId(@RequestParam("id") Integer id){ return servicio.obtenerEstudiantePorId(id);}

    @GetMapping("obtenerCedula")
    public Estudiante obtenerEstudiantePorCedula(@RequestParam("cedula") Integer cedula){ return servicio.obtenerEstudiantePorCedula(cedula);}
}
