public class CarteiraApp {
    public static void main(String[] argumentos) {
        Carteira primeira = new Carteira("Ana", 500.0);
        Carteira segunda = new Carteira("Bruno", 100.0);

        exibir("Estado inicial", primeira, segunda);
        System.out.println("Transferência de R$ 150,00: " + resultado(primeira.transferirPara(segunda, 150.0)));
        exibir("Após transferência válida", primeira, segunda);

        System.out.println("Transferência sem saldo suficiente: " + resultado(primeira.transferirPara(segunda, 1000.0)));
        exibir("Após tentativa sem saldo", primeira, segunda);

        System.out.println("Transferência sem destino: " + resultado(primeira.transferirPara(null, 50.0)));
        exibir("Após tentativa sem destino", primeira, segunda);
    }

    private static void exibir(String rotulo, Carteira primeira, Carteira segunda) {
        System.out.printf("%s | %s: R$ %.2f | %s: R$ %.2f%n",
                rotulo, primeira.obterTitular(), primeira.obterSaldo(), segunda.obterTitular(), segunda.obterSaldo());
    }

    private static String resultado(boolean sucesso) {
        return sucesso ? "sucesso" : "operação recusada";
    }
}
