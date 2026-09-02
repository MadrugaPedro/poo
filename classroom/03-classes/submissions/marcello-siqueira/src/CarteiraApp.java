/**
 * Demonstra transferencia valida, sem saldo e sem carteira de destino.
 */
public class CarteiraApp {

    public static void main(String[] argumentos) {
        Carteira minha = new Carteira("Marcello", 250.00);
        Carteira dela = new Carteira("Amanda", 40.00);

        exibir("Estado inicial", minha, dela);

        System.out.println();
        System.out.println("Transferir R$ 100.00 de Marcello para Amanda: "
                + resultado(minha.transferirPara(dela, 100.00)));
        exibir("Depois da transferência", minha, dela);

        System.out.println();
        System.out.println("Transferir R$ 5000.00 sem saldo: "
                + resultado(minha.transferirPara(dela, 5000.00)));
        exibir("Depois da recusa por saldo", minha, dela);

        System.out.println();
        System.out.println("Transferir R$ 10.00 para destino inexistente: "
                + resultado(minha.transferirPara(null, 10.00)));
        exibir("Depois da recusa por destino nulo", minha, dela);

        System.out.println();
        System.out.println("Transferir R$ 10.00 para a própria carteira: "
                + resultado(minha.transferirPara(minha, 10.00)));
        exibir("Depois da recusa por destino igual à origem", minha, dela);

        System.out.println();
        System.out.println("Caso de fronteira: titular vazio e saldo inicial negativo");
        Carteira normalizada = new Carteira("   ", -80.00);
        System.out.printf("%s | R$ %.2f%n", normalizada.obterTitular(), normalizada.obterSaldo());
    }

    private static void exibir(String rotulo, Carteira primeira, Carteira segunda) {
        System.out.printf("%s: %s R$ %.2f | %s R$ %.2f%n", rotulo,
                primeira.obterTitular(), primeira.obterSaldo(),
                segunda.obterTitular(), segunda.obterSaldo());
    }

    private static String resultado(boolean sucesso) {
        if (sucesso) {
            return "aceita";
        }
        return "recusada";
    }
}
