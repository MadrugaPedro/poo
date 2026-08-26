/**
 * Armazena os dados de uma pessoa e calcula sua frequencia cardiaca maxima
 * e a faixa de frequencia cardiaca alvo recomendada pela American Heart Association.
 */
public class HeartRates {

    /**
     * Ano de referencia usado pelos metodos que nao recebem o ano como parametro.
     * Os exemplos e os testes da atividade foram escritos com base neste ano, por isso
     * ele e fixo: assim o resultado nao muda conforme a data em que o programa roda.
     */
    private static final int ANO_REFERENCIA = 2025;

    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Retorna a idade completa da pessoa no primeiro dia do ano informado.
     * Quem nasceu depois de 1 de janeiro ainda nao fez aniversario naquele ano,
     * entao um ano e descontado da diferenca entre os anos.
     */
    public int calculateAge(int currentYear) {
        int age = currentYear - yearOfBirth;

        if (monthOfBirth > 1 || dayOfBirth > 1) {
            age = age - 1;
        }

        return age;
    }

    /**
     * Frequencia cardiaca maxima: 220 menos a idade.
     */
    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    public int calculateMaxHeartRate() {
        return calculateMaxHeartRate(ANO_REFERENCIA);
    }

    /**
     * Faixa de frequencia cardiaca alvo: de 50% a 85% da frequencia cardiaca maxima.
     */
    public String calculateTargetHeartRate(int currentYear) {
        int maxHeartRate = calculateMaxHeartRate(currentYear);
        int minimum = (int) (maxHeartRate * 0.50);
        int maximum = (int) (maxHeartRate * 0.85);

        return minimum + " bpm - " + maximum + " bpm";
    }

    public String calculateTargetHeartRate() {
        return calculateTargetHeartRate(ANO_REFERENCIA);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFormattedBirthDate() {
        return String.format("%02d/%02d/%04d", dayOfBirth, monthOfBirth, yearOfBirth);
    }
}
