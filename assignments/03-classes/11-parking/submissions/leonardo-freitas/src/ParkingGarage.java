import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        if (hours <= 3.0) return 2.0;
        if (hours >= 24.0) return 10.0;
        double charge = 2.0 + Math.ceil(hours - 3.0) * 0.50;
        return Math.min(charge, 10.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();
            if (horas == -1) break;
            if (horas < 0) {
                System.out.println("Valor inválido. Informe horas não negativas ou -1 para sair.");
                continue;
            }
            double taxa = calculateCharges(horas);
            total += taxa;
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente++, taxa);
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        scanner.close();
    }
}
