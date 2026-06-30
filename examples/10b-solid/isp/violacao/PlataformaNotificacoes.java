package isp.violacao;

public interface PlataformaNotificacoes {
    void enviarEmail(String destinatario, String mensagem);
    void enviarSms(String numero, String mensagem);
    void enviarPush(String dispositivoId, String mensagem);
}
