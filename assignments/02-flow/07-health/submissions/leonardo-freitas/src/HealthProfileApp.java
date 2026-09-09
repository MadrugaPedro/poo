import java.time.LocalDate;
import java.util.Scanner;

public class HealthProfileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu primeiro nome: ");
        String nome = scanner.next();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.next();
        System.out.print("Digite seu gênero (M/F): ");
        char genero = Character.toUpperCase(scanner.next().charAt(0));
        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dia = scanner.nextInt(), mes = scanner.nextInt(), ano = scanner.nextInt();
        System.out.print("Digite sua altura em polegadas: ");
        double altura = scanner.nextDouble();
        System.out.print("Digite seu peso em libras: ");
        double peso = scanner.nextDouble();

        HealthProfile perfil = new HealthProfile(nome, sobrenome, genero, dia, mes, ano, altura, peso);
        int[] alvo = perfil.calculateTargetHeartRate();
        System.out.println("Nome: " + perfil.getFirstName() + " " + perfil.getLastName());
        System.out.println("Gênero: " + (perfil.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", dia, mes, ano);
        System.out.println("Idade: " + perfil.calculateAge(LocalDate.now().getYear()) + " anos");
        System.out.printf("Altura: %.0f polegadas%n", perfil.getHeightInInches());
        System.out.printf("Peso: %.0f libras%n", perfil.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", perfil.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + perfil.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + alvo[0] + " bpm - " + alvo[1] + " bpm");
        System.out.println("\nTabela BMI:");
        System.out.println("Menos de 18.5  - Abaixo do peso");
        System.out.println("18.5 – 24.9    - Peso normal");
        System.out.println("25.0 – 29.9    - Sobrepeso");
        System.out.println("30.0 ou mais   - Obesidade");
        scanner.close();
    }
}
