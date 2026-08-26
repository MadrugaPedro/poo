import java.util.Scanner;

    public class FortalecerSenha{
        public static int calcularTempoDigitacao(String s){
            int tempo = 2;

            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == s.charAt(i - 1)){
                    tempo += 1;
                } else{
                    tempo += 2;
                }
            }
            return tempo;
        }

            public static String fortalecerSenha(String s){

                for(int i = 0; i < s.length() - 1; i++){
                    if(s.charAt(i) == s.charAt(i + 1)){
                        char letraNova = (s.charAt(i) == 'a') ? 'b' : 'a';
                        return s.substring(0, i + 1) + letraNova + s.substring(i + 1);
                    }
                }

                char ultimaLetra = s.charAt(s.length() - 1);
                char letraFinal = (ultimaLetra == 'a') ? 'b' : 'a';

                return s + letraFinal;
        }

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            String senhaFortalecida = fortalecerSenha(senha);
            System.out.println("Senha fortalecida: " + senhaFortalecida);

            scanner.close();
        }
    }