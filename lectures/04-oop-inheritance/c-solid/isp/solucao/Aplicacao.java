package isp.solucao;

public class Aplicacao {
    public static void main(String[] args) {
        CanalSms canalSms = new GatewaySms();
        CanalEmail canalEmail = new GatewayEmail();

        CentralNotificacoes central = new CentralNotificacoes(canalSms, canalEmail);
        central.avisarEnvio("5511999990000", "cliente@loja.com");
    }
}
