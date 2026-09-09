import java.util.Scanner;

public class AprovacaoEstudante {
    public static String avaliar(double nota1, double nota2) {
        if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
            return "NOTA INVALIDA";
        }
        double media = (nota1 + nota2) / 2.0;
        if (media >= 7) {
            return String.format("Média: %.1f — APROVADO", media);
        } else if (media >= 5) {
            return String.format("Média: %.1f — RECUPERACAO", media);
        } else {
            return String.format("Média: %.1f — REPROVADO", media);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nota1 = scanner.nextDouble();
        double nota2 = scanner.nextDouble();
        System.out.println(avaliar(nota1, nota2));
        scanner.close();
    }
}
