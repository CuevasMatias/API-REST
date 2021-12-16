package Api.demo.service;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.dto.AgregarUsuario;
import Api.demo.entity.Emprendimiento;
import Api.demo.entity.Tag;
import Api.demo.entity.Usuario;
import Api.demo.repository.EmprendimientoRepository;
import Api.demo.repository.TagRepository;
import Api.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class EmprendimientoService {

    private final EmprendimientoRepository emprendimientoRepository;
    private final UsuarioRepository usuarioRepository;
    private final TagRepository tagRepository;

    @Autowired
    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository, UsuarioRepository usuarioRepository,
                                 TagRepository tagRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tagRepository = tagRepository;
    }

    public Emprendimiento crearEmprendimiento(AgregarEmprendimiento agregarEmprendimiento) {
        Usuario usuario = usuarioRepository.findById(agregarEmprendimiento.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuario No Encontrado"));
        List<Tag> tags = tagRepository.findAllById(agregarEmprendimiento.getTags());
        Emprendimiento emprendimiento = new Emprendimiento();
        emprendimiento.setNombre(agregarEmprendimiento.getNombre());
        emprendimiento.setDescripcion(agregarEmprendimiento.getDescripcion());
        emprendimiento.setContenido(agregarEmprendimiento.getContenido());
        emprendimiento.setObjetivo(agregarEmprendimiento.getObjetivo());
        emprendimiento.setPublicado(agregarEmprendimiento.getPublicado());
        emprendimiento.setUrls(agregarEmprendimiento.getUrls());
        emprendimiento.setUsuario(usuario);
        emprendimiento.getTags().addAll(tags);

        return emprendimientoRepository.save(emprendimiento);
    }
    public List<Emprendimiento> obtenerTodos(String nombre) {
        if (nombre != null) { Tag tag = tagRepository.findByNombre(nombre);
            return tag.getEmprendimientos();
        } else { return emprendimientoRepository.findAll(); }
    }
    public Stream<Emprendimiento> obtenerNoPublicados() {
        return emprendimientoRepository.findAll().stream()
                .filter(Predicate.not(Emprendimiento::isPublicado));
    }
    public AgregarEmprendimiento editarEmprendimiento(Long id, Emprendimiento emprendimiento) {
        Emprendimiento emprendimiento1 = emprendimientoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Emprendimiento no encontrado"));
        emprendimiento1.setNombre(emprendimiento.getNombre());
        emprendimiento1.setDescripcion(emprendimiento.getDescripcion());
        emprendimiento1.setContenido(emprendimiento.getContenido());
        emprendimiento1.setUrls(emprendimiento.getUrls());
        emprendimiento1.setObjetivo(emprendimiento.getObjetivo());
        emprendimiento1.setPublicado(emprendimiento.isPublicado());
        emprendimiento1.setTags(emprendimiento.getTags());
        emprendimientoRepository.save(emprendimiento1);

        AgregarEmprendimiento agregarEmprendimiento = new AgregarEmprendimiento();
        agregarEmprendimiento.setNombre(emprendimiento1.getNombre());
        agregarEmprendimiento.setDescripcion(emprendimiento1.getDescripcion());
        agregarEmprendimiento.setContenido(emprendimiento1.getContenido());
        agregarEmprendimiento.setObjetivo(emprendimiento1.getObjetivo());
        agregarEmprendimiento.setUrls(emprendimiento1.getUrls());
        agregarEmprendimiento.setPublicado(emprendimiento1.isPublicado());
        agregarEmprendimiento.setTags(emprendimiento1.getTags());
        return agregarEmprendimiento;
    }
    public boolean eliminarEmprendimiento(Long id) {
        try{
            emprendimientoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
