package refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieTest {

    private final String title = "MP3";
    private int priceCode = 2;
    Movie movie = new Movie(title,priceCode);

    @Test
    public void shouldReturnMovieTitleSetInConstructor() {
        assertEquals(title, movie.getTitle());
    }

    @Test
    public void shouldReturnPriceCodeSetInConstructor() {
        assertEquals(priceCode, movie.getPriceCode());
    }

}
