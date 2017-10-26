package movieStore.after;

class Rental {
	private Movie movie;
	private int numDaysRented;

	public Rental(Movie movie, int numDaysRented) {
		this.movie = movie;
		this.numDaysRented = numDaysRented;
	}

	public int getNumDaysRented() {
		return numDaysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	double getPoints() {
		return movie.getPoints(numDaysRented);
	}

	double getPrice() {
		return movie.getPrice(numDaysRented);
	}
}
