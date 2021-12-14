package Api.demo.service;

import Api.demo.dto.AgregarEmprendimiento;
import Api.demo.dto.AgregarVoto;
import Api.demo.entity.*;
import Api.demo.repository.EmprendimientoRepository;
import Api.demo.repository.UsuarioRepository;
import Api.demo.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class VotoService {

    private EmprendimientoRepository emprendimientoRepository;
    private UsuarioRepository usuarioRepository;
    private VotoRepository votoRepository;

    @Autowired
    public VotoService(EmprendimientoRepository emprendimientoRepository,
                       UsuarioRepository usuarioRepository, VotoRepository votoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.votoRepository = votoRepository;
    }

    public List<AgregarVoto> getVotos(Long idUsuario) {
        List<Voto> allVotos = new ArrayList<>();
        if (Objects.isNull(idUsuario)) {
            allVotos = votoRepository.findAll();
        } else {
            usuarioRepository.findById(idUsuario)
                    .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
            allVotos = votoRepository.findByIdUsuario(idUsuario);
        }
        List<AgregarVoto> allAgregarVoto = new ArrayList<>();
        for (Voto voto : allVotos) {
            AgregarVoto agregarVoto = new AgregarVoto();
            agregarVoto.setIdUsuario(voto.getIdUsuario());
            agregarVoto.setIdEmprendimiento(voto.getIdEmprendimiento());
            agregarVoto.setGenerado(voto.getGenerado());
            allAgregarVoto.add(agregarVoto);
        }
        return allAgregarVoto;
    }

    public Voto crearVoto(AgregarVoto agregarVoto) {
        Usuario usuario = usuarioRepository.findById(agregarVoto.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuario No Encontrado"));
        Emprendimiento emprendimiento = emprendimientoRepository.findById(agregarVoto.getIdEmprendimiento())
                .orElseThrow(() -> new EntityNotFoundException("Emprendimiento no encontrado"));
        if (Objects.nonNull(usuario) && Objects.nonNull(emprendimiento)) {
            if (usuario.getUsuario().equals(TipoUsuario.USUARIO)) {
        Voto voto = new Voto();
        voto.setGenerado(agregarVoto.getGenerado());
        voto.setIdUsuario(agregarVoto.getIdUsuario());
        voto.setIdEmprendimiento(agregarVoto.getIdEmprendimiento());
        return votoRepository.save(voto);
    } else {
            return null;
        }
    } else {
        return null;}
    }
}

