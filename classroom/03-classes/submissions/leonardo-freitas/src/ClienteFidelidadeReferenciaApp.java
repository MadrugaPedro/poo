public class ClienteFidelidadeReferenciaApp {
    public static void main(String[] argumentos) {
        ClienteFidelidade referenciaOriginal = new ClienteFidelidade("Marina");
        ClienteFidelidade outraReferencia = referenciaOriginal;

        concederBonusPromocional(outraReferencia, 100);
        System.out.println("Pontos pela referência original: " + referenciaOriginal.obterPontos());
        System.out.println("Pontos pela outra referência: " + outraReferencia.obterPontos());

        substituirCliente(outraReferencia);
        System.out.println("Após reatribuir somente o parâmetro local:");
        System.out.println("Nome pela referência original: " + referenciaOriginal.obterNome());
        System.out.println("Nome pela outra referência: " + outraReferencia.obterNome());
        System.out.println("As referências ainda apontam para o mesmo objeto: " + (referenciaOriginal == outraReferencia));
    }

    private static void concederBonusPromocional(ClienteFidelidade cliente, int pontos) {
        cliente.acumularPontos(pontos);
    }

    private static void substituirCliente(ClienteFidelidade cliente) {
        cliente = new ClienteFidelidade("Cliente temporário");
        cliente.acumularPontos(999);
    }
}
