import java.util.Scanner;
import java.util.Locale;

    public class CalculadoraPoligono{
        public static double calcularArea(int n, double s){
            return (1.0 / 4.0) * Math.pow(s, 2) * n * (1/Math.tan(Math.PI / n));
        }

        public static String formatarSaida(double area){
            return String.format(Locale.US, "A área do polígono é: %.2f metros quadrados", area);
        }
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o número de lados do polígono: ");
            int lados = scanner.nextInt();

            System.out.print("Digite o comprimento do lado em metros: ");
            double comprimento = scanner.nextDouble();

            double area = calcularArea(lados, comprimento);
            String resultado = formatarSaida(area);

            System.out.println(resultado);

            scanner.close();
        }
    }