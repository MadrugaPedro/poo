package lsp.violacao;

public class ReservaBlackFriday extends ReservaHotel {
    public ReservaBlackFriday(String codigo) {
        super(codigo);
    }

    @Override
    public String cancelar() {
        throw new UnsupportedOperationException("Reservas Black Friday não podem ser canceladas");
    }
}
