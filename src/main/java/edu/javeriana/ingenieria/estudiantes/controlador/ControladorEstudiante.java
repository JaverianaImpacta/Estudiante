package edu.javeriana.ingenieria.estudiantes.controlador;

import edu.javeriana.ingenieria.estudiantes.dominio.Estudiante;
import edu.javeriana.ingenieria.estudiantes.servicio.ServicioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("obtenerSentidoMiPractica")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantes(@RequestParam boolean sentidoMiPractica){
        if(servicio.obtenerEstudiantes(sentidoMiPractica).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerEstudiantes(sentidoMiPractica), HttpStatus.OK);
    }

    @GetMapping("obtenerARL")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorArl(@RequestParam boolean arl){
        if(servicio.obtenerEstudiantesPorARL(arl).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerEstudiantesPorARL(arl), HttpStatus.OK);
    }

    @GetMapping("obtener")
    public ResponseEntity<Estudiante> obtenerEstudiante(@RequestParam Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerEstudiante(id) == null || !servicio.estudianteExiste(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerEstudiante(id), HttpStatus.OK);
    }

    @GetMapping("obtenerCorreoInstitucional")
    public ResponseEntity<Estudiante> obtenerEstudiante(@RequestParam String correoInstitucional){
        if(correoInstitucional == null || correoInstitucional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.estudianteExiste(correoInstitucional)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerEstudiante(correoInstitucional), HttpStatus.OK);
    }

    @GetMapping("obtenerCedula")
    public ResponseEntity<Estudiante> obtenerEstudiantePorCedula(@RequestParam Integer cedula){
        if(cedula == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.estudianteExistePorCedula(cedula)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerEstudiantePorCedula(cedula), HttpStatus.OK);
    }

    @GetMapping("obtenerIdInstitucional")
    public ResponseEntity<Estudiante> obtenerEstudiantePorIdInstitucional(@RequestParam Integer idInstitucional){
        if(idInstitucional == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.estudianteExistePorIdInstitucional(idInstitucional)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerEstudiantePorIdInstitucional(idInstitucional), HttpStatus.OK);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Estudiante> actualizarEstudiante(@RequestParam Integer id, @RequestBody Estudiante estudiante){
        if( id == null || estudiante == null || !id.equals(estudiante.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.actualizarEstudiante(id, estudiante) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }
}
