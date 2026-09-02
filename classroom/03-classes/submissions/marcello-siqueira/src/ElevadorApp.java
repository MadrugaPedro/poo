/**
 * Demonstra os limites de lotacao, do terreo e do ultimo andar.
 */
public class ElevadorApp {

    public static void main(String[] argumentos) {
        Elevador elevador = new Elevador(5, 4);

        System.out.printf("Elevador criado: último andar %d, capacidade %d%n",
                elevador.obterUltimoAndar(), elevador.obterCapacidade());
        System.out.printf("Estado: andar %d, %d de %d pessoas%n",
                elevador.obterAndarAtual(), elevador.obterQuantidadePessoas(), elevador.obterCapacidade());

        System.out.println();
        System.out.println("Limite de lotação");
        System.out.println("Entrar 3 pessoas: " + resultado(elevador.entrar(3)));
        System.out.println("Entrar 2 pessoas (estouraria a capacidade): " + resultado(elevador.entrar(2)));
        System.out.println("Entrar 1 pessoa: " + resultado(elevador.entrar(1)));
        System.out.println("Entrar 0 pessoa: " + resultado(elevador.entrar(0)));
        System.out.printf("Estado: andar %d, %d de %d pessoas%n",
                elevador.obterAndarAtual(), elevador.obterQuantidadePessoas(), elevador.obterCapacidade());

        System.out.println();
        System.out.println("Limite do último andar");
        for (int i = 1; i <= elevador.obterUltimoAndar(); i++) {
            System.out.println("Subir: " + resultado(elevador.subir()) + ", andar " + elevador.obterAndarAtual());
        }
        System.out.println("Subir além do último andar: " + resultado(elevador.subir()));
        System.out.printf("Estado: andar %d, %d de %d pessoas%n",
                elevador.obterAndarAtual(), elevador.obterQuantidadePessoas(), elevador.obterCapacidade());

        System.out.println();
        System.out.println("Limite do térreo");
        while (elevador.descer()) {
            System.out.println("Desceu para o andar " + elevador.obterAndarAtual());
        }
        System.out.println("Descer abaixo do térreo: " + resultado(elevador.descer()));
        System.out.printf("Estado: andar %d, %d de %d pessoas%n",
                elevador.obterAndarAtual(), elevador.obterQuantidadePessoas(), elevador.obterCapacidade());

        System.out.println();
        System.out.println("Saída de pessoas");
        System.out.println("Sair 10 pessoas (maior que a ocupação): " + resultado(elevador.sair(10)));
        System.out.println("Sair 4 pessoas: " + resultado(elevador.sair(4)));
        System.out.println("Sair 1 pessoa do elevador vazio: " + resultado(elevador.sair(1)));
        System.out.printf("Estado: andar %d, %d de %d pessoas%n",
                elevador.obterAndarAtual(), elevador.obterQuantidadePessoas(), elevador.obterCapacidade());

        System.out.println();
        System.out.println("Caso de fronteira: valores não positivos no construtor");
        Elevador normalizado = new Elevador(-3, 0);
        System.out.printf("Último andar %d, capacidade %d%n",
                normalizado.obterUltimoAndar(), normalizado.obterCapacidade());
    }

    private static String resultado(boolean sucesso) {
        if (sucesso) {
            return "aceito";
        }
        return "recusado";
    }
}
