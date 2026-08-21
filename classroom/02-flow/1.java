public class solucoes {
    public static void main(String[] args) {
        int numero = 0; 
        String tipo;

        if(numero > 0)
            tipo = "positivo";

        else if(numero < 0 )
            tipo = "negativo";

        else if(numero == 0 )
            tipo = "zero";

        else
            tipo = "???";

        System.out.println("O numero e " + tipo + ".");
    
    }

    
}
