public class Film {
    private int filmId;
    private String title;
    private int languageId;
    private int rentalDuration;
    private double rentalRate;
    private double replacementCost;

    public Film(String title, int languageId, int rentalDuration, double rentalRate, double replacementCost) {
        this.title = title;
        this.languageId = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
    }

    public Film(int filmId, String title, int languageId, int rentalDuration, double rentalRate, double replacementCost) {
        this(title, languageId, rentalDuration, rentalRate, replacementCost);
        this.filmId = filmId;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public int getLanguageId() {
        return languageId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    @Override
    public String toString() {
        return "Film{id=" + filmId + ", title='" + title + "', languageId=" + languageId
                + ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate
                + ", replacementCost=" + replacementCost + "}";
    }
}
