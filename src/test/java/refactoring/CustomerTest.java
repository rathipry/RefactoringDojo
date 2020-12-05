package refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    private final String name = "sushi";
    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer(name);
    }


    @Test
    public void testStatementWithZeroValuesForNoRentals() {
        String expectedStatement = "Rental record for " + customer.getName()  +"\nAmount owed is 0.0\nYou earned 0 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatmentForOneRentalWith0RegularMovie() {
        Rental rental = new Rental(new Movie("MP3", Movie.REGULAR), 1);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t2.0\n"
                + "Amount owed is 2.0\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalwithNewReleaseMovie() {
        Rental rental = new Rental(new Movie("MP3", Movie.NEW_RELEASE), 1);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t3.0\n"
                + "Amount owed is 3.0\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithChildrenMovie() {
        Rental rental = new Rental(new Movie("MP3", Movie.CHILDREN), 1);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t1.5\n"
                + "Amount owed is 1.5\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithRegularAnd3DaysMovie() {
        Rental rental = new Rental(new Movie("MP3", Movie.REGULAR), 3);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t3.5\n"
                + "Amount owed is 3.5\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithNewReleaseAnd3DaysMovie() {
        Rental rental = new Rental(new Movie("MP3", Movie.NEW_RELEASE), 3);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t9.0\n"
                + "Amount owed is 9.0\nYou earned 2 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementForOneRentalWithChildrenAnd4DaysMovie() {
        Rental rental = new Rental(new Movie("MP3", Movie.CHILDREN), 4);
        customer.addRental(rental);
        String expectedStatement = "Rental record for " + customer.getName()  +"\n\t" + rental.getMovie().getTitle()+"\t3.0\n"
                + "Amount owed is 3.0\nYou earned 1 frequent renter points";
        assertEquals(expectedStatement, customer.statement());
    }
}
