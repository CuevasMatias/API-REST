package Api.demo.controller;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
