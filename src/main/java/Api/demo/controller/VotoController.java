package Api.demo.controller;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.dto.AgregarVoto;
import Api.demo.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

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
        if (Objects.nonNull(votoService.crearVoto(agregarVoto))) {
            return new ResponseEntity<>(votoService.crearVoto(agregarVoto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllVotes(@RequestParam(name= "idUsuario", required = false) Long idUsuario) {
        return new ResponseEntity<>(votoService.getVotos(idUsuario), HttpStatus.OK);
    }
}
