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
        childrenMovie = new ChildrenMovie(TITLE);
        regularMovie = new RegularMovie(TITLE);
        newReleaseMovie = new NewReleaseMovie(TITLE);
    }


    @Test
    public void testStatementWithZeroValuesForNoRentals() {
        String expectedStatement = "Rental record for " + NAME  +"\nAmount owed is 0.0\nYou earned 0 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithRegularAnd1DaysRentedMovie() {
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);
        String expectedStatement = "Rental record for " + NAME  +"\n\t" + TITLE +"\t2.0\n"
                + "Amount owed is 2.0\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithNewReleaseAnd1DaysRentedMovie() {
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);
        String expectedStatement = "Rental record for " + NAME  +"\n\t" + TITLE +"\t3.0\n"
                + "Amount owed is 3.0\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithChildrenAnd1DaysRentedMovie() {
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);
        String expectedStatement = "Rental record for " + NAME +"\n\t" + TITLE +"\t1.5\n"
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
        String expectedStatement = "Rental record for " + NAME  +"\n\t" + TITLE +"\t6.5\n"
                + "\t" + rental2.getMovie().getTitle()+"\t15.0\n"
                + "\t" + rental3.getMovie().getTitle()+"\t4.5\n"
                + "Amount owed is 26.0\nYou earned 4 frequent renter points";
        assertEquals(expectedStatement, customer.statement());

    }
}
