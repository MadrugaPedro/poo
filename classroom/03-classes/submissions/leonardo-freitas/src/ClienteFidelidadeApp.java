public class ClienteFidelidadeApp {
    public static void main(String[] argumentos) {
        ClienteFidelidade cliente = new ClienteFidelidade("Leonardo");

        cliente.acumularPontos(120);
        System.out.println("Após acúmulo: " + situacao(cliente));

        System.out.println("Resgate de 50 pontos: " + resultado(cliente.resgatarPontos(50)));
        System.out.println("Após resgate: " + situacao(cliente));

        System.out.println("Resgate sem saldo suficiente: " + resultado(cliente.resgatarPontos(100)));

        cliente.desativar();
        cliente.acumularPontos(30);
        System.out.println("Após desativação e tentativa de acúmulo: " + situacao(cliente));
        System.out.println("Resgate após desativação: " + resultado(cliente.resgatarPontos(10)));
    }

    private static String resultado(boolean sucesso) {
        return sucesso ? "sucesso" : "operação recusada";
    }

    private static String situacao(ClienteFidelidade cliente) {
        return String.format("%s | pontos: %d | cadastro: %s",
                cliente.obterNome(), cliente.obterPontos(), cliente.estaAtivo() ? "ativo" : "inativo");
    }
}
