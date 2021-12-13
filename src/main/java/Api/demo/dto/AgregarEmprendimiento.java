package Api.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AgregarEmprendimiento {

    @NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;

    @NotEmpty(message = "La descripcion no puede ser vacio")
    private String descripcion;
    private String contenido;
    @NotNull(message = "El objetivo no puede ser vacio")
    private Double objetivo;
    private boolean publicado;
    private String urls;

    @NotNull
    @Positive
    @JsonProperty(value = "id_usuario")
    private Long idUsuario;

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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Double getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Double objetivo) {
        this.objetivo = objetivo;
    }

    public boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}




