import java.util.Scanner;

public class Turma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] notas = {10, 8, -1, 6, 4, 11, 7};
        int valido = 0;
        int invalido = 0;
        double media = 0;
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;

        for (int i : notas) {
            if (i >= 0 && i <= 10){
                valido = valido + 1;
                media = media + i;
            }
            
            switch (i) {
                case 10, 9 -> A++;
                case 7, 8 -> B = B + 1;
                case 6, 5 -> C = C + 1;
                case 1, 2, 3, 4 -> D = D + 1;
                default -> invalido++;
                    
            }
        
        }
        
        media = media/valido;
        System.out.println("Notas validas: " + valido);
        System.out.println("Notas invalidas: " + invalido);
        System.out.println("Media: " + media);
        System.out.println("A: " + A);
        System.out.println("B: " + B);
        System.out.println("C: " + C);
        System.out.println("D: " + D);


        
        scanner.close();
    }
}

