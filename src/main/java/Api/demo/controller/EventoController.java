package Api.demo.controller;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.dto.AgregarEvento;
import Api.demo.service.EmprendimientoService;
import Api.demo.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

    private final EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<?> crearEvento(@Valid @RequestBody AgregarEvento agregarEvento) {
        return new ResponseEntity<>(eventoService.crearEvento(agregarEvento), HttpStatus.CREATED);
    }
}
