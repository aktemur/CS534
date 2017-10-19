package movieStore.after;

class Movie {
	private String _title;
	private PriceCode _priceCode;

	public Movie(String title, PriceCode priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public PriceCode getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(PriceCode arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	double getPoints(int numDaysRented) {
		return _priceCode.getPoints(numDaysRented);
	}

	double getPrice(int numDaysRented) {
		return _priceCode.getPrice(numDaysRented);
	}
}
