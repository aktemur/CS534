package movieStore.before;

import java.util.Vector;

class Customer {
   private String _name;
   private Vector<Rental> _rentals = new Vector<Rental>();

   public Customer(String name) {
      _name = name;
   }

   public void addRental(Rental arg) {
      _rentals.addElement(arg);
   }

   public String getName() {
      return _name;
   }

   public String statement() {
      double totalAmount = 0;
      int frequentRenterPoints = 0;
      String result = "Rental Record for " + getName() + "\n";
      for (Rental rental : _rentals) {
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
