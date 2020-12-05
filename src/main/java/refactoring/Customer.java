package refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

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

        StringBuilder result = formStartResultString();

        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
            double amount = rental.calculateAmount();
            result.append(formResultStringWithValues(rental, amount));
            totalAmount += amount;
        }

        result.append(formEndResultString(totalAmount, frequentRenterPoints));
        return String.valueOf(result);
    }

    private StringBuilder formEndResultString(double totalAmount, int frequentRenterPoints) {
        return new StringBuilder("Amount owed is ").append(totalAmount)
                .append("\n").append("You earned ").append(frequentRenterPoints)
                .append(" frequent renter points");
    }

    private StringBuilder formResultStringWithValues(Rental rental, double amount) {
        return new StringBuilder().append("\t")
                .append(rental.getMovie().getTitle()).append("\t")
                .append(amount).append("\n");
    }

    public StringBuilder formStartResultString() {
        return new StringBuilder("Rental record for ").append(getName()).append("\n");
    }

}
