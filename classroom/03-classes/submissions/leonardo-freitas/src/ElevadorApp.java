public class ElevadorApp {
    public static void main(String[] argumentos) {
        Elevador elevador = new Elevador(3, 4);

        System.out.println("Entrar 4 pessoas: " + resultado(elevador.entrar(4)));
        System.out.println("Entrar mais 1 pessoa: " + resultado(elevador.entrar(1)));

        while (elevador.subir()) {
            System.out.println("Subiu para o andar " + elevador.obterAndarAtual());
        }
        System.out.println("Tentar subir além do último andar: " + resultado(elevador.subir()));

        while (elevador.descer()) {
            System.out.println("Desceu para o andar " + elevador.obterAndarAtual());
        }
        System.out.println("Tentar descer abaixo do térreo: " + resultado(elevador.descer()));

        System.out.println("Sair 5 pessoas: " + resultado(elevador.sair(5)));
        System.out.println("Sair 4 pessoas: " + resultado(elevador.sair(4)));
    }

    private static String resultado(boolean sucesso) {
        return sucesso ? "sucesso" : "operação recusada";
    }
}
