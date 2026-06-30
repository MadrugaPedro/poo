public class Film {

        private String title;
        private int languafeId;
        private int rentalDuration;
        private double rentalRate;
        private double replacementCost;

    public Film(String title, int languafeId,int rentalDuration,double rentalRate,double replacementCost){

        this.title = title;
        this.languafeId = languafeId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
   
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLanguafeId() {
        return languafeId;
    }

    public void setLanguafeId(int languafeId) {
        this.languafeId = languafeId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    
}
