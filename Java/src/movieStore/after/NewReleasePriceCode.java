package movieStore.after;

class NewReleasePriceCode extends PriceCode {
	// Class variable "instance" and the "getInstance" methods
	// show how the Singleton pattern is typically implemented
	private static PriceCode instance = null;

	public static PriceCode getInstance() {
		// Create an instance on-demand,
		// when the instance is requested for the first time.
		if (instance == null) {
			instance = new NewReleasePriceCode();
		}
		return instance;
	}

	// This constructor is *private* to ensure no one
	// can instantiate this class
	private NewReleasePriceCode() {
	}

	public double getPoints(int numDaysRented) {
		return (numDaysRented > 1) ? 2 : 1;
	}

	protected double getAmountPerExtraDay() {
		return 3;
	}

	protected int getBaseDays() {
		return 0;
	}

	protected double getBaseAmount() {
		return 0;
	}
}
