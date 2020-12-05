package refactoring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RentalTest {

    private static final String title = "MP3";
    private static int priceCode = 2;
    private static Movie movie ;
    private static Rental rental;
    private static final int daysRented = 2;

    @BeforeAll
    public static void setup() {
        movie = new Movie(title,priceCode);
        rental = new Rental(movie, daysRented);
    }

    @Test
    public void shouldReturnMovieObjectSetInConstructor() {
        assertTrue(movie.equals(rental.getMovie()));
        assertTrue(daysRented == rental.getDaysRented());
    }
}
