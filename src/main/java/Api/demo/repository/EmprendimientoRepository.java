package Api.demo.repository;


import Api.demo.entity.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmprendimientoRepository extends JpaRepository < Emprendimiento, Long > {
    public abstract ArrayList<Emprendimiento> findByNombre (String nombre);
}
