package Api.demo.dto;

public class AgregarVoto {

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
