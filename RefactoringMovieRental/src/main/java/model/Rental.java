package model;

public class Rental {
    private final Movie movie;
    private final int daysRented;
    
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
    
    int getFrequentRenterPoints() {
        return  movie.getFrequentRenterPoints(daysRented);
    }
    
    double getCharge() {
        return movie.getCharge(daysRented);
    }
}
