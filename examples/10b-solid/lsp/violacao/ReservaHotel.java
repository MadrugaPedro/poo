package lsp.violacao;

public class ReservaHotel {
    private final String codigo;
    private String status = "confirmada";

    public ReservaHotel(String codigo) {
        this.codigo = codigo;
    }

    public String cancelar() {
        status = "cancelada";
        return "Reserva " + codigo + " cancelada com reembolso integral";
    }

    public String getStatus() {
        return status;
    }
}
