public class EstatisticasTurma {
    public static void main(String[] args) {
        int[] notas = {10, 8, -1, 6, 4, 11, 7};
        int a = 0, b = 0, c = 0, d = 0;
        int invalidas = 0;
        int soma = 0;
        int validas = 0;

        for (int nota : notas) {
            if (nota < 0 || nota > 10) {
                invalidas++;
                continue;
            }

            soma += nota;
            validas++;
            if (nota >= 9) {
                a++;
            } else if (nota >= 7) {
                b++;
            } else if (nota >= 5) {
                c++;
            } else {
                d++;
            }
        }

        double media = validas == 0 ? 0.0 : (double) soma / validas;
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        System.out.println("D: " + d);
        System.out.printf("Média: %.2f%n", media);
        System.out.println("Inválidas ignoradas: " + invalidas);
    }
}
