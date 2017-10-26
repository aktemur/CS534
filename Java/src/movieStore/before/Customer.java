package movieStore.before;

import java.util.LinkedList;
import java.util.List;

class Customer {
   private String name;
   private List<Rental> rentals;

   public Customer(String name) {
      this.name = name;
      this.rentals = new LinkedList<Rental>();
   }

   public void addRental(Rental arg) {
      rentals.add(arg);
   }

   public String getName() {
      return name;
   }

   public String statement() {
      double totalAmount = 0;
      int frequentRenterPoints = 0;
      String result = "Rental Record for " + getName() + "\n";
      for (Rental rental : rentals) {
         double amount = 0;
         // determine amounts for each line
         switch (rental.getMovie().getPriceCode()) {
         case Movie.REGULAR:
            amount = 2;
            if (rental.getNumDaysRented() > 2)
               amount += (rental.getNumDaysRented() - 2) * 1.5;
            break;
         case Movie.NEW_RELEASE:
            amount = rental.getNumDaysRented() * 3;
            break;
         case Movie.CHILDRENS:
            amount = 1.5;
            if (rental.getNumDaysRented() > 3)
               amount += (rental.getNumDaysRented() - 3) * 1.5;
            break;
         }

         // add frequent renter points
         frequentRenterPoints++;
         // add bonus for a two day new release rental
         if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
               && rental.getNumDaysRented() > 1)
            frequentRenterPoints++;

         // show figures for this rental
         result += "\t" + rental.getMovie().getTitle() + "\t"
               + String.valueOf(amount) + "\n";
         totalAmount += amount;
      }
      // add footer lines
      result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
      result += "You earned " + String.valueOf(frequentRenterPoints)
            + " frequent renter points";
      return result;
   }
}
