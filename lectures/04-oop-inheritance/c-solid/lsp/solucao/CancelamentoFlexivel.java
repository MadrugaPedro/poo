package lsp.solucao;

public class CancelamentoFlexivel implements PoliticaCancelamento {
    @Override
    public String cancelar(ReservaHotel reserva) {
        reserva.atualizarStatus("cancelada");
        return "Reserva " + reserva.getCodigo() + " cancelada com reembolso integral";
    }
}
