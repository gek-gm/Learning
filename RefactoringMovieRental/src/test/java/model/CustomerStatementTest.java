package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerStatementTest {
    private Customer testCustomer;
    
    @Before public void setUpTest() {
        testCustomer = new Customer("John Doe");
    }
    
    @Test public void when_RentRegularMovieFor2Days_Expect_statementContainsCorrectAmount() {
        Movie testMovie = new Movie("Kill Bill", 0);
        Rental testRental = new Rental(testMovie, 2);
        testCustomer.addRental(testRental);
        
        String statement = testCustomer.statement();
        
        String expectedString = "Amount owed is 2.0\n";
        assertTrue(statement.contains(expectedString));
    }
    
    @Test public void when_RentRegularMovieFor4Days_Expect_statementContainsCorrectAmount() {
        Movie movie = new Movie("Kill Bill", 0);
        Rental rental = new Rental(movie, 4);
        testCustomer.addRental(rental);
        
        String statement = testCustomer.statement();
        
        String expectedString = "Amount owed is 5.0\n";
        assertTrue(statement.contains(expectedString));
    }
    
    @Test public void when_RentNewReleaseMovie_Expect_statementContainsCorrectAmount() {
        Movie movie = new Movie("Interstellar", 1);
        Rental rental = new Rental(movie, 3);
        testCustomer.addRental(rental);
        
        String statement = testCustomer.statement();
        
        String expectedString = "Amount owed is 9.0\n";
        assertTrue(statement.contains(expectedString));
    }
    
    @Test public void when_RentChildrensMovieLessThan3Days_Expect_statementContainsCorrectAmount() {
        Movie movie = new Movie("Toy Story 4", 2);
        Rental rental = new Rental(movie, 3);
        testCustomer.addRental(rental);
        
        String statement = testCustomer.statement();
        
        String expectedString = "Amount owed is 1.5\n";
        assertTrue(statement.contains(expectedString));
    }
    
    @Test public void when_RentChildrensMovieMoreThan3Days_Expect_statementContainsCorrectAmount() {
        Movie movie = new Movie("Toy Story 4", 2);
        Rental rental = new Rental(movie, 5);
        testCustomer.addRental(rental);
        
        String statement = testCustomer.statement();
        
        String expectedString = "Amount owed is 4.5\n";
        assertTrue(statement.contains(expectedString));
    }
    
    @Test public void when_MultipleRentalsNotNewRelease_Expect_statementContainsRenterPoints() {
        Movie[] movies = {
                new Movie("Toy Story 4", 2),
                new Movie("Toy Story 3", 2),
                new Movie("Toy Story 2", 2)
        };
        for(Movie movie : movies) {
            Rental rental = new Rental(movie, 5);
            testCustomer.addRental(rental);
        }
        
        String statement = testCustomer.statement();
        
        String expectedString = "You earned 3 frequent renter points";
        assertTrue(statement.contains(expectedString));
    }
    
    @Test public void when_NewReleaseMoreThan1Day_Expect_statementContainsRenterPoints() {
        Movie[] movies = {
                new Movie("The Lion King", 1),
                new Movie("Avengers: Endgame", 1),
                new Movie("Joker", 1)
        };
        for(Movie movie : movies) {
            Rental rental = new Rental(movie, 2);
            testCustomer.addRental(rental);
        }
        
        String statement = testCustomer.statement();
        
        String expectedString = "You earned 6 frequent renter points";
        assertTrue(statement.contains(expectedString));
    }
}
