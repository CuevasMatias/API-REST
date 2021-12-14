package Api.demo.service;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.dto.AgregarEvento;
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
}
