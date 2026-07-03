package isp.solucao;

public class CentralNotificacoes {
    private final CanalSms canalSms;
    private final CanalEmail canalEmail;

    public CentralNotificacoes(CanalSms canalSms, CanalEmail canalEmail) {
        this.canalSms = canalSms;
        this.canalEmail = canalEmail;
    }

    public void avisarEnvio(String numeroSms, String emailCliente) {
        String mensagem = "Seu pedido saiu para entrega!";
        canalSms.enviarSms(numeroSms, mensagem);
        canalEmail.enviarEmail(emailCliente, mensagem);
    }
}
