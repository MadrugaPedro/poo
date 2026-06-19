import java.util.Locale;
import java.util.Scanner;

public class GradeAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int numStudents = 0;

        while (true) {
            System.out.print("Digite a quantidade de estudantes: ");
            if (scanner.hasNextInt()) {
                numStudents = scanner.nextInt();
                if (numStudents > 0) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Valor inválido. A quantidade de estudantes deve ser maior que zero.");
        }

        int[] grades = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            while (true) {
                System.out.printf("Digite a nota do estudante %d: ", i + 1);
                if (scanner.hasNextInt()) {
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades[i] = grade;
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("Nota inválida. A nota deve ser um valor inteiro entre 0 e 100.");
            }
        }

        double average = calculateAverage(grades);
        int highestGrade = findHighestGrade(grades);
        int lowestGrade = findLowestGrade(grades);
        int gradesAtOrAboveAvg = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);

        System.out.println();
        System.out.printf(Locale.US, "Média da turma: %.2f\n", average);
        System.out.println("Maior nota: " + highestGrade);
        System.out.println("Menor nota: " + lowestGrade);
        System.out.println("Notas acima ou iguais à média: " + gradesAtOrAboveAvg);
        
        System.out.println("\nDistribuição de notas:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        scanner.close();
    }

    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public static int findLowestGrade(int[] grades) {
        int min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        double average = calculateAverage(grades);
        int count = 0;
        for (int grade : grades){
            if (grade >= average){
                count++;
            }
        }
        return count;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] frequency = new int[11];
        for (int grade : grades) {
            frequency[grade / 10]++;
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        } else {
            int start = index * 10;
            int end = start + 9;
            return String.format("%02d-%02d: %d", start, end, frequency);
        }
    }
}