import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

/**
 * Le os dados do paciente, cria um objeto HealthProfile e exibe as informacoes
 * calculadas junto com a tabela de referencia do indice de massa corporal.
 */
public class HealthProfileApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double heightInInches = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = scanner.nextDouble();

        HealthProfile patient = new HealthProfile(firstName, lastName, gender,
                dayOfBirth, monthOfBirth, yearOfBirth, heightInInches, weightInPounds);

        int currentYear = LocalDate.now().getYear();

        System.out.println();
        System.out.println("Nome: " + patient.getFullName());
        System.out.println("Gênero: " + patient.getGenderDescription());
        System.out.println("Data de nascimento: " + patient.getFormattedBirthDate());
        System.out.println("Idade: " + patient.calculateAge(currentYear) + " anos");
        System.out.printf("Altura: %.0f polegadas%n", patient.getHeightInInches());
        System.out.printf("Peso: %.0f libras%n", patient.getWeightInPounds());
        System.out.printf(Locale.US, "Índice de Massa Corporal (BMI): %.1f%n", patient.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + patient.calculateMaxHeartRate(currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + patient.calculateTargetHeartRate(currentYear));

        printBMITable();

        scanner.close();
    }

    private static void printBMITable() {
        System.out.println();
        System.out.println("Tabela de referência do BMI");
        System.out.println("+------------------+-----------------+");
        System.out.println("| BMI              | Classificação   |");
        System.out.println("+------------------+-----------------+");
        System.out.println("| Menos de 18.5    | Abaixo do peso  |");
        System.out.println("| 18.5 - 24.9      | Peso normal     |");
        System.out.println("| 25.0 - 29.9      | Sobrepeso       |");
        System.out.println("| 30.0 ou mais     | Obesidade       |");
        System.out.println("+------------------+-----------------+");
    }
}
