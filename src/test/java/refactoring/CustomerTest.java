package refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private static final String TITLE = "MP3";
    private static final String NAME = "sushi";

    private Customer customer;
    private static Movie childrenMovie;
    private static Movie regularMovie;
    private static Movie newReleaseMovie;


    @BeforeEach
    public void setup() {
        customer = new Customer(NAME);
        childrenMovie = new Movie(TITLE, Movie.CHILDREN);
        regularMovie = new Movie(TITLE, Movie.REGULAR);
        newReleaseMovie = new Movie(TITLE, Movie.NEW_RELEASE);
    }


    @Test
    public void testStatementWithZeroValuesForNoRentals() {
        String expectedStatement = "Rental record for " + customer.getName()  +"\nAmount owed is 0.0\nYou earned 0 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithRegularAnd1DaysRentedMovie() {
        Rental rental = new Rental(regularMovie, 1);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t2.0\n"
                + "Amount owed is 2.0\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithNewReleaseAnd1DaysRentedMovie() {
        Rental rental = new Rental(newReleaseMovie, 1);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t3.0\n"
                + "Amount owed is 3.0\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithChildrenAnd1DaysRentedMovie() {
        Rental rental = new Rental(childrenMovie, 1);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t1.5\n"
                + "Amount owed is 1.5\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForThreeRentalWithEachTypeMoviesFor5RentedDays() {
        Rental rental1 = new Rental(regularMovie, 5);
        Rental rental2 = new Rental(newReleaseMovie, 5);
        Rental rental3 = new Rental(childrenMovie, 5);
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental1.getMovie().getTitle()+"\t6.5\n"
                + "\t" + rental2.getMovie().getTitle()+"\t15.0\n"
                + "\t" + rental3.getMovie().getTitle()+"\t4.5\n"
                + "Amount owed is 26.0\nYou earned 4 frequent renter points";
        assertEquals(expectedStatement, customer.statement());

    }
}
