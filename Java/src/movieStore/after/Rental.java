package movieStore.after;

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

	double getPoints() {
		return _movie.getPoints(_numDaysRented);
	}

	double getPrice() {
		return _movie.getPrice(_numDaysRented);
	}
}
