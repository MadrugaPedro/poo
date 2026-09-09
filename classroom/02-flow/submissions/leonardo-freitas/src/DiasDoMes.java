import java.util.Scanner;

public class DiasDoMes {
    public static boolean ehBissexto(int ano) {
        return ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0);
    }

    public static int quantidadeDias(int mes, int ano) {
        return switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> ehBissexto(ano) ? 29 : 28;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();
        int dias = quantidadeDias(mes, ano);
        System.out.println(dias < 0 ? "MES INVALIDO" : dias + " dias");
        scanner.close();
    }
}
