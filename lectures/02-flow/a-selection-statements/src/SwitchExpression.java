public class SwitchExpression {
    public static void main(String[] args) {
        int month = 2;
        int year = 2024;

        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                boolean leapYear = year % 400 == 0
                        || year % 4 == 0 && year % 100 != 0;
                yield leapYear ? 29 : 28;
            }
            default -> 0;
        };

        if (days == 0) {
            System.out.println("Invalid month: " + month);
        } else {
            System.out.printf("Month %d of %d has %d days.%n", month, year, days);
        }
    }
}
