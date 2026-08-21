import java.util.Scanner;

    public class DiasdoMes{
        public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();
        int dias;

        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            dias = 31;
            break;
        case 4: case 6: case 9: case 11:
            dias = 30;
            break;
        case 2:
            boolean anoBissexto = (ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0);
            dias = anoBissexto ? 29 : 28;
            break;
        default:
            dias = 0;
            break;
        };

            if(dias == 0){
                System.out.println("Mês invalido: " + mes);
            } else{
                System.out.printf("%d dias\n", dias);
            }

        scanner.close();
        }
    }

