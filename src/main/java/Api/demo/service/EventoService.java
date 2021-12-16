package Api.demo.service;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.dto.AgregarEvento;
import Api.demo.dto.AgregarUsuario;
import Api.demo.entity.Emprendimiento;
import Api.demo.entity.Evento;
import Api.demo.entity.Tag;
import Api.demo.entity.Usuario;
import Api.demo.repository.EmprendimientoRepository;
import Api.demo.repository.EventoRepository;
import Api.demo.repository.TagRepository;
import Api.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final EmprendimientoRepository emprendimientoRepository;


    @Autowired
    public EventoService(EventoRepository eventoRepository, EmprendimientoRepository emprendimientoRepository) {
        this.eventoRepository = eventoRepository;
        this.emprendimientoRepository = emprendimientoRepository;
    }

    public Evento crearEvento(AgregarEvento agregarEvento) {
        List<Emprendimiento> emprendimientos = emprendimientoRepository.findAllById(agregarEvento.getEmprendimiento());
        Evento evento = new Evento();
        evento.setNombre(agregarEvento.getNombre());
        evento.setDescripcion(agregarEvento.getDescripcion());
        evento.setFechaDeAlta(agregarEvento.getFechaDeAlta());
        evento.setFechaDeCurso(agregarEvento.getFechaDeCurso());
        evento.setFechaDeCierre(agregarEvento.getFechaDeCierre());
        evento.setEstado(agregarEvento.getEstado());
        evento.setPremio(agregarEvento.getPremio());
        evento.getEmprendimientos().addAll(emprendimientos);

        return eventoRepository.save(evento);
    }

    public AgregarEvento editarEvento(Long id, Evento evento) {
        Evento evento1 = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        evento1.setNombre(evento.getNombre());
        evento1.setDescripcion(evento.getDescripcion());
        evento1.setFechaDeAlta(evento.getFechaDeAlta());
        evento1.setFechaDeCurso(evento.getFechaDeCurso());
        evento1.setFechaDeCierre(evento.getFechaDeCierre());
        evento1.setPremio(evento.getPremio());
        evento1.setEstado(evento.getEstado());
        eventoRepository.save(evento1);

        AgregarEvento agregarEvento = new AgregarEvento();
        agregarEvento.setNombre(evento1.getNombre());
        agregarEvento.setDescripcion(evento1.getDescripcion());
        agregarEvento.setFechaDeAlta(evento1.getFechaDeAlta());
        agregarEvento.setFechaDeCurso(evento1.getFechaDeCurso());
        agregarEvento.setFechaDeCierre(evento1.getFechaDeCierre());
        agregarEvento.setPremio(evento1.getPremio());
        agregarEvento.setEstado(evento1.getEstado());
        return agregarEvento;
    }

    public boolean eliminarEvento(Long id) {
        try{
            eventoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
