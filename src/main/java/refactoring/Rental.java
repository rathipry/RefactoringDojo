package refactoring;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateRegularMovieAmount() {
        if(daysRented <= 2)
            return 2;
        return 2+((daysRented-2) * 1.5);
    }

    public double calculateNewReleaseMovieAmount() {
        return daysRented * 3;
    }

    public double calculateChildrenMovieAmount() {
        if(daysRented <= 3)
            return 1.5;
        return 1.5+((daysRented-3) * 1.5);
    }

    public int getFrequentRenterPoints() {
        if (movie instanceof NewReleaseMovie && daysRented > 1)
            return 2;
        return 1;
    }

    public double calculateAmount() {
        if(movie instanceof RegularMovie)
            return calculateRegularMovieAmount();
        if(movie instanceof  NewReleaseMovie)
            return calculateNewReleaseMovieAmount();
        if(movie instanceof ChildrenMovie)
            return calculateChildrenMovieAmount();
        return 0;
    }
}
