package Api.demo.controller;

import Api.demo.entity.Usuario;
import Api.demo.repository.UsuarioRepository;
import Api.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository,
                             UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(@RequestParam(name = "fecha", required = false)
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaDeCreacion,
                                                     @RequestParam(name = "ciudad", required = false) String ciudad) {
        return new ResponseEntity<>(usuarioService.obtenerTodos(fechaDeCreacion, ciudad), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable("id") Long id,
                                      @RequestBody @Valid Usuario usuario) {
        return new ResponseEntity<>(usuarioService.editarUsuario(id, usuario), HttpStatus.OK);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No se pudo eliminar el usuario con id" + id;
        }
    }

}


