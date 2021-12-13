package Api.demo.entity;

import net.bytebuddy.build.ToStringPlugin;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;
    @NotEmpty(message = "El apellido no puede ser vacio")
    private String apellido;
    @NotEmpty(message = "El email no puede ser vacio")
    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @Column(unique = true, length = 45)
    private String email;
    @NotEmpty(message = "El password no puede ser vacio")
    @Size(min = 8, max = 20)
    private String password;
    private String ciudad;
    private String provincia;
    private String pais;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoUsuario usuario;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToStringPlugin.Exclude
    private List<Emprendimiento> emprendimientos;
    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;
    @UpdateTimestamp
    private LocalDateTime fechaDeModificacion;

    public Usuario(){
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    public String getApellido () {
        return apellido;
    }

    public void setApellido (String apellido){
        this.apellido = apellido;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public String getCiudad () {
        return ciudad;
    }

    public void setCiudad (String ciudad){
        this.ciudad = ciudad;
    }

    public String getProvincia () {
        return provincia;
    }

    public void setProvincia (String provincia){
        this.provincia = provincia;
    }

    public String getPais () {return pais;}

    public void setPais (String pais){
        this.pais = pais;
    }

    public TipoUsuario getUsuario() {return usuario;}

    public void setUsuario(TipoUsuario usuario) {this.usuario = usuario;}

    public LocalDateTime getFechaDeCreacion() {return fechaDeCreacion;}

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {this.fechaDeCreacion = fechaDeCreacion;}

    public LocalDateTime getFechaDeModificacion() {return fechaDeModificacion;}

    public void setFechaDeModificacion(LocalDateTime fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;}

    public List<Emprendimiento> getEmprendimientos() {
        return emprendimientos;}

    public void agregarEmprendimiento(Emprendimiento emprendimiento) {
        emprendimientos.add(emprendimiento);
        emprendimiento.setUsuario(this);
    }

    public void removerEmprendimiento(Emprendimiento emprendimiento) {
        emprendimientos.remove(emprendimiento);
        emprendimiento.setUsuario(null);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}