package Api.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private LocalDate fechaDeAlta;
    private LocalDate fechaDeCurso;
    private LocalDate fechaDeCierre;
    private EstadoEvento estado;
    @ManyToMany(mappedBy = "eventos")
    @JsonIgnoreProperties({"descripcion","contenido","objetivo","publicado","urls"})
    @OrderBy("votesCount DESC")
    private List<Emprendimiento> emprendimientos = new ArrayList<>();
    private Double premio;

    public Evento(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public LocalDate getFechaDeCurso() {
        return fechaDeCurso;
    }

    public void setFechaDeCurso(LocalDate fechaDeCurso) {
        this.fechaDeCurso = fechaDeCurso;
    }

    public LocalDate getFechaDeCierre() {
        return fechaDeCierre;
    }

    public void setFechaDeCierre(LocalDate fechaDeCierre) {
        this.fechaDeCierre = fechaDeCierre;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public List<Emprendimiento> getEmprendimientos() {
        return emprendimientos;
    }

    public void setEmprendimientos(List<Emprendimiento> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    public void agregarEmprendimiento(Emprendimiento emprendimiento){
        emprendimientos.add(emprendimiento);
        emprendimiento.getEventos().add(this);}

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fechaDeAlta=" + fechaDeAlta +
                ", fechaDeCurso=" + fechaDeCurso +
                ", fechaDeCierre=" + fechaDeCierre +
                ", estado=" + estado +
                ", emprendimientos=" + emprendimientos +
                ", premio=" + premio +
                '}';
    }
}
