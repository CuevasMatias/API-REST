package Api.demo.service;

import Api.demo.dto.AgregarUsuario;
import Api.demo.entity.Usuario;
import Api.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodos(LocalDateTime fechaDeCreacion, String ciudad) {
        if (fechaDeCreacion != null) {return usuarioRepository.findByFechaDeCreacion(fechaDeCreacion);
        } else if (ciudad != null) { return usuarioRepository.findByCiudad(ciudad);
        } else { return usuarioRepository.findAll(); }
    }

    public AgregarUsuario editarUsuario(Long id, Usuario usuario) {
        Usuario usuario1 = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        usuario1.setNombre(usuario.getNombre());
        usuario1.setApellido(usuario.getApellido());
        usuario1.setPassword(usuario.getPassword());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setCiudad(usuario.getCiudad());
        usuario1.setProvincia(usuario.getProvincia());
        usuario1.setPais(usuario.getPais());
        usuario1.setUsuario(usuario.getUsuario());
        usuarioRepository.save(usuario1);

        AgregarUsuario agregarUsuario = new AgregarUsuario();
        agregarUsuario.setNombre(usuario1.getNombre());
        agregarUsuario.setApellido(usuario1.getApellido());
        agregarUsuario.setEmail(usuario1.getEmail());
        agregarUsuario.setPassword(usuario1.getPassword());
        agregarUsuario.setCiudad(usuario1.getCiudad());
        agregarUsuario.setProvincia(usuario1.getProvincia());
        agregarUsuario.setPais(usuario1.getPais());
        agregarUsuario.setUsuario(usuario1.getUsuario());
        return agregarUsuario;
    }

    public boolean eliminarUsuario(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
