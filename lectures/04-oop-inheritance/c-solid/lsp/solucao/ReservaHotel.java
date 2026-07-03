package lsp.solucao;

public class ReservaHotel {
    private final String codigo;
    private String status = "confirmada";
    private final PoliticaCancelamento politica;

    public ReservaHotel(String codigo, PoliticaCancelamento politica) {
        this.codigo = codigo;
        this.politica = politica;
    }

    public String cancelar() {
        return politica.cancelar(this);
    }

    public String getCodigo() {
        return codigo;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public String getStatus() {
        return status;
    }
}
