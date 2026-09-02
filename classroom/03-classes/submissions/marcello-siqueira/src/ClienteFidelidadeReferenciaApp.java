/**
 * Mostra a diferenca entre alterar o objeto alcancado pela referencia
 * e reatribuir a variavel que guarda a referencia.
 *
 * Java passa parametros por valor. Quando o parametro e de um tipo por
 * referencia, o que se copia e a referencia, nao o objeto. Por isso:
 * chamar um metodo no parametro altera o objeto que o chamador tambem enxerga,
 * mas atribuir outro objeto ao parametro so troca a copia local.
 */
public class ClienteFidelidadeReferenciaApp {

    public static void main(String[] argumentos) {
        ClienteFidelidade referenciaOriginal = new ClienteFidelidade("Marcello Siqueira");
        ClienteFidelidade outraReferencia = referenciaOriginal;

        System.out.println("Duas variáveis apontando para o mesmo objeto");
        System.out.println("referenciaOriginal: " + referenciaOriginal.obterNome()
                + ", " + referenciaOriginal.obterPontos() + " pontos");
        System.out.println("outraReferencia:    " + outraReferencia.obterNome()
                + ", " + outraReferencia.obterPontos() + " pontos");
        System.out.println("As duas alcançam o mesmo objeto? "
                + (referenciaOriginal == outraReferencia));

        System.out.println();
        System.out.println("Bônus promocional de 300 pontos usando outraReferencia");
        concederBonusPromocional(outraReferencia, 300);
        System.out.println("referenciaOriginal: " + referenciaOriginal.obterPontos() + " pontos");
        System.out.println("outraReferencia:    " + outraReferencia.obterPontos() + " pontos");
        System.out.println("A alteração é vista pelas duas variáveis, porque o objeto é o mesmo.");

        System.out.println();
        System.out.println("Tentando substituir o cliente dentro do método");
        substituirCliente(referenciaOriginal);
        System.out.println("referenciaOriginal continua sendo: " + referenciaOriginal.obterNome()
                + ", " + referenciaOriginal.obterPontos() + " pontos");
        System.out.println("Reatribuir o parâmetro trocou apenas a cópia local da referência.");
    }

    /**
     * Altera o objeto recebido. O efeito e visivel para o chamador.
     */
    private static void concederBonusPromocional(ClienteFidelidade cliente, int pontos) {
        cliente.acumularPontos(pontos);
    }

    /**
     * Reatribui apenas o parametro. O chamador continua com o objeto anterior.
     */
    private static void substituirCliente(ClienteFidelidade cliente) {
        cliente = new ClienteFidelidade("Cliente Substituto");
        cliente.acumularPontos(999);
        System.out.println("Dentro do método, cliente agora é: " + cliente.obterNome()
                + ", " + cliente.obterPontos() + " pontos");
    }
}
