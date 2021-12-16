package Api.demo.controller;

import Api.demo.dto.AgregarEvento;
import Api.demo.entity.Evento;

import Api.demo.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

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

    @GetMapping
    public ResponseEntity<?> obtenerEventos(){
        return new ResponseEntity<>(eventoService.obtenerEventos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/ranking")
    public ResponseEntity<?> rankingDelEvento(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventoService.rankear(id), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> editarEvento(@PathVariable("id") Long id,
                                           @RequestBody @Valid Evento evento) {
        return new ResponseEntity<>(eventoService.editarEvento(id, evento), HttpStatus.OK);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.eventoService.eliminarEvento(id);
        if (ok){
            return "Se eliminó el evento con id " + id;
        }else{
            return "No se pudo eliminar el evento con id" + id;
        }
    }
}
