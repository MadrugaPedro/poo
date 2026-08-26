import java.util.Scanner;

	public class Maior{
		public static void main(String[] args){
			Scanner scanner = new Scanner(System.in);
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();
			int num3 = scanner.nextInt();
			int maior;

			if(num1 >= num2 && num1 >= num3)
				maior = num1;
			else if(num2 >= num3 && num2 >= num1)
				maior = num2;
			else
				maior = num3;

			String resultado = "Maior: " + maior;

			if((num1 == maior && num2 == maior) || (num1 == maior && num3 == maior) || (num2 == maior && num3 == maior))
				resultado = resultado + " — EMPATE NO MAIOR VALOR";

            Scanner(close);

			System.out.println(resultado);
		}
	}