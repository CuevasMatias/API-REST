package Api.demo.dto;

import java.time.LocalDateTime;

public class AgregarVoto {

    private String generado;
    private Long idUsuario;
    private Long idEmprendimiento;
    private LocalDateTime fechaDeCreacion;
    private boolean votado;

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

    public LocalDateTime getFechaDeCreacion() {return fechaDeCreacion;}

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;}

    public boolean isVotado() {return votado;}

    public void setVotado(boolean votado) {
        this.votado = votado;
    }
}
