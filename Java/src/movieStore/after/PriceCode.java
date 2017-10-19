package movieStore.after;

abstract class PriceCode {
	public double getPoints(int numDaysRented) {
		return 1;
	}

	// This is a TEMPLATE METHOD for price calculation
	public double getPrice(int numDaysRented) {
		double amount = getBaseAmount();
		if (numDaysRented > getBaseDays())
			amount += (numDaysRented - getBaseDays()) * getAmountPerExtraDay();
		return amount;
	}

	protected abstract double getBaseAmount();
	protected abstract int getBaseDays();
	protected abstract double getAmountPerExtraDay();
}
