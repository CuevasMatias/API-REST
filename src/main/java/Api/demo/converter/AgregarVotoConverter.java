package Api.demo.converter;

import Api.demo.dto.AgregarVoto;
import Api.demo.entity.Voto;
import Api.demo.repository.EmprendimientoRepository;
import Api.demo.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Component
public class AgregarVotoConverter implements Converter<AgregarVoto,Voto> {

    public AgregarVotoConverter(EmprendimientoRepository emprendimientoRepository,
                                UsuarioRepository usuarioRepository) {
        }
        @Override
        public Voto convert (AgregarVoto agregarVoto) {
            Voto voto = new Voto();
            voto.setGenerado(agregarVoto.getGenerado());
            voto.setIdUsuario(agregarVoto.getIdUsuario());
            voto.setIdEmprendimiento(agregarVoto.getIdEmprendimiento());
            voto.setFechaDeCreacion(LocalDateTime.now());
            return voto;
        }
}
