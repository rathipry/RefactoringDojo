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

    public int getDaysRented() {
        return daysRented;
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
        if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            return 2;
        return 1;
    }

    public double calculateAmount() {
        double amount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                amount += calculateRegularMovieAmount();
                break;
            case Movie.NEW_RELEASE:
                amount += calculateNewReleaseMovieAmount();
                break;
            case Movie.CHILDREN:
                amount += calculateChildrenMovieAmount();
                break;
        }
        return amount;
    }
}
