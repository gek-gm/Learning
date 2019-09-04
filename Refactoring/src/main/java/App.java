import model.Customer;
import model.Movie;
import model.Rental;

public class App {
    
    public static void main(String[] args) {
        System.out.println("Refactoring from Fowler");
        Customer testCustomer = new Customer("ABC DEF");
        Movie movie = new Movie("Toy Story 4", 1);
        Rental rental = new Rental(movie, 3);
        testCustomer.addRental(rental);
        System.out.println(testCustomer.statement());
        
    }

}
