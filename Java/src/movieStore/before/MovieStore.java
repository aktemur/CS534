package movieStore.before;

public class MovieStore {
   public static void main(String[] args) {
      Customer ahmet = new Customer("Ahmet");
      Movie sevenSamurai = new Movie("Seven Samurai", Movie.REGULAR);
      Movie corpseBride = new Movie("Corpse Bride", Movie.CHILDRENS);
      Movie inception = new Movie("Inception", Movie.NEW_RELEASE);
      Rental rentalS = new Rental(sevenSamurai, 3);
      Rental rentalC = new Rental(corpseBride, 2);
      Rental rentalI = new Rental(inception, 5);

      System.out.println("Movie Title : " + sevenSamurai.getTitle());
      System.out.println("Rental Time : " + rentalS.getNumDaysRented());

      System.out.println("Movie Title : " + corpseBride.getTitle());
      System.out.println("Rental Time : " + rentalC.getNumDaysRented());

      System.out.println("Movie Title : " + inception.getTitle());
      System.out.println("Rental Time : " + rentalI.getNumDaysRented());

      System.out.println("------------------------------------");
      ahmet.addRental(rentalS);
      System.out.println(ahmet.statement());
      System.out.println("------------------------------------");
      ahmet.addRental(rentalC);
      System.out.println(ahmet.statement());
      System.out.println("------------------------------------");
      ahmet.addRental(rentalI);
      System.out.println(ahmet.statement());
   }
}

