import java.time.LocalDate;
import java.util.Scanner;

public class HeartRatesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu primeiro nome: ");
        String nome = scanner.next();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.next();
        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();

        HeartRates pessoa = new HeartRates(nome, sobrenome, dia, mes, ano);
        int idade = pessoa.calculateAge(LocalDate.now().getYear());
        int max = pessoa.calculateMaxHeartRate();
        int[] alvo = pessoa.calculateTargetHeartRate();

        System.out.println("Nome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Frequência cardíaca máxima: " + max + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + alvo[0] + " bpm - " + alvo[1] + " bpm");
        scanner.close();
    }
}
