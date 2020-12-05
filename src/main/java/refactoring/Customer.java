package refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double amount = 0;
            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    amount += calculateRegularMovieAmount(rental);
                    break;
                case Movie.NEW_RELEASE:
                    amount += calculateNewReleaseMovieAmount(rental);
                    break;
                case Movie.CHILDREN:
                    amount += calculateChildrenMovieAmount(rental);
                    break;
            }

            frequentRenterPoints += getFrequentRenterPoints(rental);

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";

            totalAmount += amount;
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }


    public double calculateRegularMovieAmount(Rental rental) {
        if(rental.getDaysRented() <= 2)
            return 2;
        return 2 + ((rental.getDaysRented() - 2) * 1.5);
    }

    public double calculateNewReleaseMovieAmount(Rental rental) {
        return rental.getDaysRented() * 3;
    }

    public double calculateChildrenMovieAmount(Rental rental) {
        if(rental.getDaysRented() <= 3)
            return 1.5;
        return 1.5 + ((rental.getDaysRented() - 3) * 1.5);
    }

    public int getFrequentRenterPoints(Rental rental) {
        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
            return 2;
        return 1;
    }


}
