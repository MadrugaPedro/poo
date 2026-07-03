package isp.violacao;

public class GatewaySms implements PlataformaNotificacoes {
    @Override
    public void enviarEmail(String destinatario, String mensagem) {
        throw new UnsupportedOperationException("SMS gateway não envia e-mails");
    }

    @Override
    public void enviarSms(String numero, String mensagem) {
        System.out.println("Enviando SMS para " + numero + ": " + mensagem);
    }

    @Override
    public void enviarPush(String dispositivoId, String mensagem) {
        throw new UnsupportedOperationException("SMS gateway não envia push");
    }
}
