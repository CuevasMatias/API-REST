package Api.demo.service;

import Api.demo.dto.AgregarVoto;
import Api.demo.entity.Emprendimiento;
import Api.demo.entity.Voto;
import Api.demo.repository.EmprendimientoRepository;
import Api.demo.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final Converter<AgregarVoto, Voto> agregarVotoConverter;
    private final VotoRepository votoRepository;

    @Autowired
    public VotoService(EmprendimientoRepository emprendimientoRepository,
                       Converter <AgregarVoto, Voto> agregarVotoConverter,
                       VotoRepository votoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.agregarVotoConverter = agregarVotoConverter;
        this.votoRepository = votoRepository;
    }

    public boolean chequearVoto(AgregarVoto agregarVoto){
        Voto voto = agregarVotoConverter.convert(agregarVoto);
        return votoRepository.findAll().stream().anyMatch(v -> {
            assert voto != null;
            return v.getIdUsuario().equals(voto.getIdUsuario()) && v.getIdEmprendimiento().equals(voto.getIdEmprendimiento());
        });
    }
    public Boolean crearVoto(AgregarVoto agregarVoto) {
        Voto voto = agregarVotoConverter.convert(agregarVoto);
        if(!chequearVoto(agregarVoto)){
            assert voto != null;
            Emprendimiento emprendimiento = emprendimientoRepository.getById(voto.getIdEmprendimiento());
            emprendimiento.setContadorDeVotos(emprendimiento.getContadorDeVotos()+1);
            emprendimientoRepository.save(emprendimiento);
            votoRepository.save(voto);
            return true;
        }
        return false;
    }
    public List<Voto> obtenerVotos(Long Idusuario) {
        return votoRepository.findByIdUsuario(Idusuario);
    }
}


