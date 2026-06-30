package isp.solucao;

public class GatewayEmail implements CanalEmail {
    @Override
    public void enviarEmail(String destinatario, String mensagem) {
        System.out.println("Enviando e-mail para " + destinatario + ": " + mensagem);
    }
}
