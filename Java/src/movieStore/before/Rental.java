package movieStore.before;

class Rental {
   private Movie _movie;
   private int _numDaysRented;

   public Rental(Movie movie, int numDaysRented) {
      _movie = movie;
      _numDaysRented = numDaysRented;
   }

   public int getNumDaysRented() {
      return _numDaysRented;
   }

   public Movie getMovie() {
      return _movie;
   }
}
