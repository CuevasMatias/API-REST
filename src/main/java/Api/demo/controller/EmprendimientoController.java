package Api.demo.controller;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.entity.Emprendimiento;
import Api.demo.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/emprendimiento")
public class EmprendimientoController {

    private final EmprendimientoService emprendimientoService;

    @Autowired
    public EmprendimientoController(EmprendimientoService emprendimientoService) {
        this.emprendimientoService = emprendimientoService;
    }

    @PostMapping
    public ResponseEntity<?> crearEmprendimiento(@Valid @RequestBody AgregarEmprendimiento agregarEmprendimiento) {
        return new ResponseEntity<>(emprendimientoService.crearEmprendimiento(agregarEmprendimiento), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosEmprendimientos(
            @RequestParam(name = "nombre", required = false) String nombre) {
        return new ResponseEntity<>(emprendimientoService.obtenerTodos(nombre) ,HttpStatus.OK);
    }
    @GetMapping(value = "/no_publicados")
    public ResponseEntity<?> obtenerEmprendimientosNoPublicados() {
        return new ResponseEntity<>(emprendimientoService.obtenerNoPublicados(), HttpStatus.OK);
    }

    @PutMapping( path = "/{id}")
    public ResponseEntity<?> editarEmprendimiento(@PathVariable("id") Long id,
                                         @RequestBody @Valid Emprendimiento emprendimiento) {
        return new ResponseEntity<>(emprendimientoService.editarEmprendimiento(id, emprendimiento), HttpStatus.OK);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.emprendimientoService.eliminarEmprendimiento(id);
        if (ok){
            return "Se eliminó el emprendimiento con id " + id;
        }else{
            return "No se pudo eliminar el emprendimiento con id" + id;
        }
    }
}

