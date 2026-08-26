import java.time.LocalDate;
import java.util.Scanner;

/**
 * Le os dados da pessoa, cria um objeto HeartRates e exibe a idade,
 * a frequencia cardiaca maxima e a faixa de frequencia cardiaca alvo.
 */
public class HeartRatesApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);

        int currentYear = LocalDate.now().getYear();

        System.out.println();
        System.out.println("Nome: " + person.getFullName());
        System.out.println("Data de nascimento: " + person.getFormattedBirthDate());
        System.out.println("Idade: " + person.calculateAge(currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate(currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate(currentYear));

        scanner.close();
    }
}
