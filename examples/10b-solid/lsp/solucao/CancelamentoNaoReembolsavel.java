package lsp.solucao;

public class CancelamentoNaoReembolsavel implements PoliticaCancelamento {
    @Override
    public String cancelar(ReservaHotel reserva) {
        reserva.atualizarStatus("encerrada");
        return "Reserva " + reserva.getCodigo() + " cancelada sem reembolso. Crédito disponível.";
    }
}
