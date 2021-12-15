package Api.demo.repository;

import Api.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository < Usuario, Long> {

    List<Usuario> findByCiudad(String ciudad);
    List<Usuario> findByFechaDeCreacion(LocalDateTime fechaDeCreacion);

}