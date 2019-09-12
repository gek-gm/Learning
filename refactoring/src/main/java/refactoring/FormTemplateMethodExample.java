package refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class FormTemplateMethodExample {
    
    public abstract class Statement{
        
        public String value(Customer aCustomer) {
            Enumeration<Rental> rentals = aCustomer.getRentals().elements();
            String result = headerString(aCustomer);
            // show figures for this rental
            while (rentals.hasMoreElements()) {
                Rental each = rentals.nextElement();
                result += eachRentalString(each);
            }
            result += footerString(aCustomer);
            return result;
        }
        
        abstract String headerString(Customer aCustomer);
        abstract String eachRentalString(Rental aRental);
        abstract String footerString(Customer aCustomer);
        
    }
    
    public class HtmlStatement extends Statement{
        
        @Override
        public String headerString(Customer aCustomer) {
            return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
        }
        
        @Override
        public String eachRentalString(Rental aRental) {
            return aRental.getMovie().getTitle()+ ": " + String.valueOf(aRental.getCharge()) + "<BR>\n";
        }
        
        @Override
        public String footerString(Customer aCustomer) {
            return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" +
            "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + 
            " frequent renter points";
        }
    }

    public class TextStatement extends Statement{
        
        @Override
        public String headerString(Customer aCustomer) {
            return "Rental Record for " + aCustomer.getName() + "\n";
        }
        
        @Override
        public String eachRentalString(Rental aRental) {
            return "\t" + aRental.getMovie().getTitle()+ "\t" + String.valueOf(aRental.getCharge()) + "\n";
        }
        
        @Override
        public String footerString(Customer aCustomer) {
            return "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n" +
            "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + 
            " frequent renter points";
        }
    }
    
    
    
    
    public class Rental{
        public Movie getMovie() {
            return new Movie();
        }
        public double getCharge() {
            return 0.0;
        }
    }
    
    public class Movie{
        public String getTitle() {
            return "title";
        }
    }
   
    public class Customer{
        
        private final Vector<Rental> _rentals = new Vector<>();
        
        public String statement() {
            return new TextStatement().value(this);
        }
        
        public String htmlStatement() {
            return new HtmlStatement().value(this);
        }
        
        public String getName() {
            return "name";
        }
        
        public Vector<Rental> getRentals() {
            return _rentals;
        }
        public double getTotalCharge() {
            return 2.0;
        }
        public int getTotalFrequentRenterPoints() {
            return 5;
        }
    }
    
}
