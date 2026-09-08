import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        System.out.println("Senha fortalecida: " + fortalecerSenha(senha));
        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        if (s == null || s.length() < 1 || s.length() > 10 || !s.matches("[a-z]+")) {
            throw new IllegalArgumentException("A senha deve conter de 1 a 10 letras minúsculas.");
        }

        String melhor = null;
        int melhorTempo = -1;
        for (int posicao = 0; posicao <= s.length(); posicao++) {
            for (char letra = 'a'; letra <= 'z'; letra++) {
                String candidata = s.substring(0, posicao) + letra + s.substring(posicao);
                int tempo = calcularTempoDigitacao(candidata);
                if (tempo > melhorTempo) {
                    melhorTempo = tempo;
                    melhor = candidata;
                }
            }
        }
        return melhor;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) return 0;
        int tempo = 2;
        for (int i = 1; i < senha.length(); i++) {
            tempo += senha.charAt(i) == senha.charAt(i - 1) ? 1 : 2;
        }
        return tempo;
    }
}
