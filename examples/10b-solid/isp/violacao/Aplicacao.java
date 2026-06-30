package isp.violacao;

public class Aplicacao {
    public static void main(String[] args) {
        PlataformaNotificacoes gatewaySms = new GatewaySms();
        gatewaySms.enviarSms("5511999990000", "Seu pedido saiu para entrega!");
        gatewaySms.enviarEmail("cliente@loja.com", "Seu pedido saiu para entrega!");
    }
}
