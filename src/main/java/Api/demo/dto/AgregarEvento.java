package Api.demo.dto;

import Api.demo.entity.EstadoEvento;

import java.time.LocalDate;
import java.util.List;

public class AgregarEvento {

    private String nombre;
    private String descripcion;
    private LocalDate fechaDeAlta;
    private LocalDate fechaDeCurso;
    private LocalDate fechaDeCierre;
    private EstadoEvento estado;
    private List<Long> emprendimiento;
    private Double premio;

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

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    public List<Long> getEmprendimiento() {
        return emprendimiento;
    }

    public void setEmprendimiento(List<Long> emprendimiento) {
        this.emprendimiento = emprendimiento;
    }
}
