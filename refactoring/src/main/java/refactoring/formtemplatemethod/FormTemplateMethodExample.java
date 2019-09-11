package refactoring.formtemplatemethod;

import java.util.Enumeration;

public class FormTemplateMethodExample {
   
    public static class Customer{
        
        public String statement() {
            Enumeration rentals = _rentals.elements();
            String result = "Rental Record for " + getName() + "\n";
            while (rentals.hasMoreElements()) {
                Rental each = (Rental) rentals.nextElement();
                //show figures for this rental
                result += "\t" + each.getMovie().getTitle()+ "\t" +
                String.valueOf(each.getCharge()) + "\n";
            }
            //add footer lines
            result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
            result += "You earned " +
            String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
            return result;
        }
        
        public String htmlStatement() {
            Enumeration rentals = _rentals.elements();
            String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
            while (rentals.hasMoreElements()) {
                Rental each = (Rental) rentals.nextElement();
                //show figures for each rental
                result += each.getMovie().getTitle()+ ": " +
                String.valueOf(each.getCharge()) + "<BR>\n";
            }
            //add footer lines
            result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
            result += "On this rental you earned <EM>" +
            String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
            return result;
        }
        
    }
}
