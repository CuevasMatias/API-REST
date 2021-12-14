package Api.demo.service;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.entity.Emprendimiento;
import Api.demo.entity.Tag;
import Api.demo.entity.Usuario;
import Api.demo.repository.EmprendimientoRepository;
import Api.demo.repository.TagRepository;
import Api.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
}
