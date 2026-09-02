import java.util.Scanner;

    public class PassosElefante{
        public static int calcularPassosMinimos(int x){
            int qtd_passos = x / 5;

            if(x % 5 == 0){
                return qtd_passos;
            } else {
                return qtd_passos + 1;
            }
        }

        public static String formatarSaida(int resultado){
            return String.format("O número mínimo de passos necessários é: %d", resultado);
        }

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a posição da casa do amigo: ");
            int posicao = scanner.nextInt();

            if(posicao >= 1 && posicao <= 1000000){
                int passos = calcularPassosMinimos(posicao);
                String resultadoFinal = formatarSaida(passos);
                System.out.println(resultadoFinal);
            } else{
                System.out.println("Posição inválida");
            }
            scanner.close();
        }
    }