package Api.demo.controller;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.dto.AgregarVoto;
import Api.demo.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value= "/voto")
public class VotoController {

    private final VotoService votoService;

    @Autowired
    public VotoController(VotoService votoService) {
        this.votoService = votoService;
    }
    @PostMapping
    public ResponseEntity<?> crearVoto(@Valid @RequestBody AgregarVoto agregarVoto) {
        return new ResponseEntity<>(votoService.crearVoto(agregarVoto), HttpStatus.CREATED);
    }
}
