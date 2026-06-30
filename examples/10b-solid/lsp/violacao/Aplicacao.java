package lsp.violacao;

public class Aplicacao {
    public static void main(String[] args) {
        CentralReservas central = new CentralReservas();

        ReservaHotel reservaPadrao = new ReservaHotel("ABC123");
        System.out.println(central.cancelarReserva(reservaPadrao));

        ReservaHotel reservaPromocional = new ReservaBlackFriday("BF567");
        System.out.println(central.cancelarReserva(reservaPromocional));
    }
}
