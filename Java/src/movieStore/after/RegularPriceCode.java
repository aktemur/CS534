package movieStore.after;

class RegularPriceCode extends PriceCode {
	// Class variable "instance" and the "getInstance" methods
	// show how the Singleton pattern is typically implemented
	private static PriceCode instance = null;

	public static PriceCode getInstance() {
		// Create an instance on-demand,
		// when the instance is requested for the first time.
		if (instance == null) {
			instance = new RegularPriceCode();
		}
		return instance;
	}

	// This constructor is *private* to ensure no one
	// can instantiate this class
	private RegularPriceCode() {
	}

	protected double getAmountPerExtraDay() {
		return 1.5;
	}

	protected int getBaseDays() {
		return 2;
	}

	protected double getBaseAmount() {
		return 2;
	}
}
