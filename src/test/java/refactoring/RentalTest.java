package refactoring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {

    private static final String TITLE = "MP3";
    private static Movie childrenMovie;
    private static Movie regularMovie;
    private static Movie newReleaseMovie;

    @BeforeAll
    public static void setup() {
        childrenMovie = new ChildrenMovie(TITLE);
        regularMovie = new RegularMovie(TITLE);
        newReleaseMovie = new NewReleaseMovie(TITLE);
    }

    @Test
    public void testRegularMovieCalculationWith1And3RentedDays() {
        Rental rental1 = new Rental(regularMovie, 1);
        Rental rental3 = new Rental(regularMovie, 3);
        assertEquals(rental1.calculateAmount(), 2);
        assertEquals(rental3.calculateAmount(), 3.5);
    }

    @Test
    public void testNewReleaseMovieCalculationWith5RentedDays() {
        Rental rental5 = new Rental(newReleaseMovie, 5);
        assertEquals(rental5.calculateAmount(), 15);
    }

    @Test
    public void testChildrenMovieCalculationWith3And6RentedDays() {
        Rental rental3 = new Rental(childrenMovie, 3);
        Rental rental6 = new Rental(childrenMovie, 6);
        assertEquals(rental3.calculateAmount(), 1.5);
        assertEquals(rental6.calculateAmount(), 6.0);
    }

    @Test
    public void testFrequentPointersForEachMovieTypesAnd3RentedDays() {
        assertEquals(new Rental(childrenMovie, 3).getFrequentRenterPoints(), 1);
        assertEquals(new Rental(regularMovie, 3).getFrequentRenterPoints(), 1);
        assertEquals(new Rental(newReleaseMovie, 3).getFrequentRenterPoints(), 2);
    }

}
