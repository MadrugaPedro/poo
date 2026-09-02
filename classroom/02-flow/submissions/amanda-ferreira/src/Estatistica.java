public class Estatistica {
    public static void main(String[] args){
        int[] notas = {10, 8, -1, 6, 4, 11, 7};
        int invalidas = 0;
        int validas = 0;
        int soma = 0;
        int a = 0; int b = 0; int c = 0; int d = 0;

        for(int nota : notas){
            if(nota < 0 || nota > 10){
                invalidas++;
                continue;
            }
            validas++;
            soma += nota;

            switch(nota){
                case 10: case 9:
                    a++;
                    break;
                case 8: case 7:
                    b++;
                    break;
                case 6: case 5:
                    c++;
                    break;
                case 4: case 3: case 2: case 1: case 0:
                    d++;
                    break;
            }
        }
        double media = (double) soma / validas;
        System.out.println("Válidas: " + validas);
        System.out.println("Inválidas: " + invalidas);
        System.out.printf("Média: %.2f\n", media);
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        System.out.println("D: " + d);
    }
}