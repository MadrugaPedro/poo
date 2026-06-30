package lsp.solucao;

public class Aplicacao {
    public static void main(String[] args) {
        CentralReservas central = new CentralReservas();

        ReservaHotel reservaFlex = new ReservaHotel("ABC123", new CancelamentoFlexivel());
        System.out.println(central.cancelarReserva(reservaFlex));

        ReservaHotel reservaPromocional = new ReservaHotel("BF567", new CancelamentoNaoReembolsavel());
        System.out.println(central.cancelarReserva(reservaPromocional));
    }
}
