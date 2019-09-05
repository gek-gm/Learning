package model;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<Rental>();
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }
    
    public String getName() {
        return name;
    }
    
    public String statement() {
        double totalAmount = 0;
        int frequentRenderPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while(rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();
            
            thisAmount = amountFor(each);

            // add frequent renter points
            frequentRenderPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenderPoints++;
            
            //show figures for this rental
            result += "\t" + each.getMovie() .getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenderPoints) + " frequent renter points";
        return result;
    }
    
    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }
    
}
