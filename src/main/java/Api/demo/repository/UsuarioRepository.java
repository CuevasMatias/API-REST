package Api.demo.repository;

import Api.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository < Usuario, Long> {
    public abstract ArrayList<Usuario> findByCiudad (String ciudad);
    public abstract ArrayList<Usuario> findByFechaDeCreacionAfter(LocalDateTime fechaDesde);
}