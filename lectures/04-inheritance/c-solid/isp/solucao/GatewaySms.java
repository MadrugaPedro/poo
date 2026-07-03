package isp.solucao;

public class GatewaySms implements CanalSms {
    @Override
    public void enviarSms(String numero, String mensagem) {
        System.out.println("Enviando SMS para " + numero + ": " + mensagem);
    }
}
