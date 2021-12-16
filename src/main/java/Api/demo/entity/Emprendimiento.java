package Api.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emprendimiento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;
    @NotEmpty(message = "La descripcion no puede ser vacio")
    private String descripcion;
    private String contenido;
    @NotNull(message = "El objetivo no puede ser vacio")
    private Double objetivo;
    private boolean publicado;
    private String urls;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "empredimiento_id",
            joinColumns = @JoinColumn(name = "emprendimiento_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @JsonIgnoreProperties({"id"})
    private List<Tag> tags = new ArrayList<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "idEmprendimiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Voto> votos = new ArrayList<Voto>();
    private Integer contadorDeVotos = 0;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Evento> eventos = new ArrayList<>();
    @CreationTimestamp
    @Column(name = "fechaDeAlta")
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column(name = "fechaDeActualizacion")
    private LocalDateTime modifiedDate;

    public Emprendimiento(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }

    public String getContenido () {
        return contenido;
    }

    public void setContenido (String contenido){
        this.contenido = contenido;
    }

    public Double getObjetivo () {
        return objetivo;
    }

    public void setObjetivo (Double objetivo){
        this.objetivo = objetivo;
    }

    public boolean isPublicado () {
        return publicado;
    }

    public void setPublicado ( boolean publicado){
        this.publicado = publicado;
    }

    public LocalDateTime getCreateDate () {
        return createDate;}

    public void setCreateDate (LocalDateTime createDate){
        this.createDate = createDate;
    }

    public LocalDateTime getModifiedDate () {
        return modifiedDate;}

    public void setModifiedDate (LocalDateTime modifiedDate){
        this.modifiedDate = modifiedDate;
    }

    public String getUrls() {return urls;}

    public void setUrls(String urls) {this.urls = urls;}

    public Usuario getUsuario() {
        return usuario;}

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;}

    public List<Voto> getVotos() {
        return votos;}

    public void setVotos(List<Voto> votos) {
        this.votos = votos;}

    public Integer getContadorDeVotos() {
        return contadorDeVotos;}

    public void setContadorDeVotos(Integer contadorDeVotos) {
        this.contadorDeVotos = contadorDeVotos;}

    public List<Evento> getEventos() {return eventos;}

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;}

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
        evento.getEmprendimientos().add(this);}

    public void agregarTag(Tag tag) {
        tags.add(tag);
        tag.getEmprendimientos().add(this);}

    public void removerTag(Tag tag) {
        tags.remove(tag);
        tag.getEmprendimientos().remove(null);}

    public List<Tag> getTags() {
        return tags;}

    @Override
    public String toString() {
        return "Emprendimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contenido='" + contenido + '\'' +
                ", objetivo=" + objetivo +
                ", publicado=" + publicado +
                ", urls='" + urls + '\'' +
                ", usuario=" + usuario +
                ", tags=" + tags +
                ", votos=" + votos +
                ", contadorDeVotos=" + contadorDeVotos +
                ", eventos=" + eventos +
                ", createDate=" + createDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}