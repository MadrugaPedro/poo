import java.util.Scanner;

    public class Calcular{
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            double num1 = scanner.nextDouble();
            String operador = scanner.next();
            double num2 = scanner.nextDouble();
            Double resultado;

            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    System.out.println(resultado);
                    break;
                case "-":
                    resultado = num1 - num2;
                    System.out.println(resultado);
                    break;
                case "*":
                    resultado = num1 * num2;
                    System.out.println(resultado);
                case "/":
                    if(num2 != 0){
                        resultado = num1 / num2;
                        System.out.println(resultado);
                    } else{
                        System.out.println("DIVISAO POR ZERO\n");
                    }
                    break;
                default:
                    System.out.println("OPERADOR INVALIDO\n");
                    break;
                }
            scanner.close();
        }
    }
    