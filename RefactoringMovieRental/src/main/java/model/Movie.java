package model;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    
    private String title;
    private Price price;
    
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }
    
    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }
    
    public String setTitle() {
        return title;
    }
    
    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    public void setPriceCode(int arg) {
        switch(arg) {
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case Movie.CHILDRENS:
                price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
    
    public void setTitle(String arg) {
        title = arg;
    }
    
    abstract class Price{
        abstract int getPriceCode();
        abstract double getCharge(int daysRented);
        
        /**
         * @param daysRented  
         */
        int getFrequentRenterPoints(int daysRented) {
            return 1;
        }
        
    }

    class ChildrensPrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.CHILDRENS;
        }
        
        @Override
        double getCharge(int daysRented) {
            double result = 1.5;
            if (daysRented > 3)
                result += (daysRented - 3 ) * 1.5;
            return result;
        }
        
    }

    class NewReleasePrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.NEW_RELEASE;
        }
        
        @Override
        double getCharge(int daysRented) {
            return daysRented * 3;
        }
        
        @Override
        int getFrequentRenterPoints(int daysRented) {
            return (daysRented > 1) ? 2 : 1;
        }
        
    }

    class RegularPrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.REGULAR;
        }
        
        @Override
        double getCharge(int daysRented) {
            double result = 2;
            if (daysRented > 2 )
                result += (daysRented - 2 ) * 1.5;
            return result;
        }
        
    }
}


