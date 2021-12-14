package Api.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;
    @NotEmpty(message = "La descripcion no puede ser vacio")
    private String descripcion;
    @NotNull(message = "Tiene que presentar fecha")
    private LocalDate fechaDeAlta;
    @NotNull(message = "Tiene que presentar fecha")
    private LocalDate fechaDeCurso;
    @NotNull(message = "Tiene que presentar fecha")
    private LocalDate fechaDeCierre;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoEvento estado;
    @ManyToMany(mappedBy = "eventos")
    @JsonIgnoreProperties({"contenido","objetivo","publicado","tags","urls"})
    private List<Emprendimiento> emprendimientos = new ArrayList<>();
    @NotNull(message = "El premio no puede ser vacio")
    private Double premio;

    public Evento(){}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void agregarEmprendimientos(Emprendimiento emprendimiento){
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
                ", nombre='" + nombre + '\'' +
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
