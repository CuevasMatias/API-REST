package Api.demo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "No puede ser vacio")
    private String generado;
    private Long idUsuario;
    private Long idEmprendimiento;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenerado() {
        return generado;
    }

    public void setGenerado(String generado) {
        this.generado = generado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdEmprendimiento() {
        return idEmprendimiento;
    }

    public void setIdEmprendimiento(Long idEmprendimiento) {
        this.idEmprendimiento = idEmprendimiento;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", generado='" + generado + '\'' +
                ", idUsuario=" + idUsuario +
                ", idEmprendimiento=" + idEmprendimiento +
                ", fechaDeCreacion=" + fechaDeCreacion +
                '}';
    }
}


