/**
 * Demonstra acumulo, resgate valido, resgate sem saldo e operacao apos desativacao.
 */
public class ClienteFidelidadeApp {

    public static void main(String[] argumentos) {
        ClienteFidelidade cliente = new ClienteFidelidade("Marcello Siqueira");
        ClienteFidelidade outro = new ClienteFidelidade("");

        System.out.println("Dois clientes independentes");
        System.out.println(situacao(cliente));
        System.out.println(situacao(outro));

        System.out.println();
        System.out.println("Acúmulo de 500 pontos no primeiro cliente");
        cliente.acumularPontos(500);
        System.out.println(situacao(cliente));
        System.out.println(situacao(outro));

        System.out.println();
        System.out.println("Acúmulo de -100 pontos: " + situacao(cliente));
        cliente.acumularPontos(-100);
        System.out.println("Depois da tentativa: " + situacao(cliente));

        System.out.println();
        System.out.println("Resgate de 200 pontos: " + resultado(cliente.resgatarPontos(200)));
        System.out.println(situacao(cliente));

        System.out.println();
        System.out.println("Resgate de 1000 pontos sem saldo: " + resultado(cliente.resgatarPontos(1000)));
        System.out.println(situacao(cliente));

        System.out.println();
        System.out.println("Desativação do cadastro");
        cliente.desativar();
        System.out.println(situacao(cliente));
        System.out.println("Acúmulo de 50 pontos após desativar");
        cliente.acumularPontos(50);
        System.out.println("Resgate de 10 pontos após desativar: " + resultado(cliente.resgatarPontos(10)));
        System.out.println(situacao(cliente));
    }

    private static String resultado(boolean sucesso) {
        if (sucesso) {
            return "aceito";
        }
        return "recusado";
    }

    private static String situacao(ClienteFidelidade cliente) {
        String estado;

        if (cliente.estaAtivo()) {
            estado = "ativo";
        } else {
            estado = "inativo";
        }

        return cliente.obterNome() + " | " + cliente.obterPontos() + " pontos | " + estado;
    }
}
