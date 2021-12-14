package Api.demo.dto;

import javax.validation.constraints.NotEmpty;

public class AgregarVoto {
    @NotEmpty(message = "No puede ser vacio")
    private String generado;
    private Long idUsuario;
    private Long idEmprendimiento;

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
}
