package movieStore.after;

import java.util.Vector;

abstract class PriceCode {
	public double getPoints(int numDaysRented) {
		return 1;
	}

	// This is a template method for price calculation
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

class Childrens extends PriceCode {
	// Class variable "instance" and the "getInstance" methods
	// show how the Singleton pattern is typically implemented
	private static PriceCode instance = null;
	
	public static PriceCode getInstance() {
		// Create an instance on-demand,
		// when the instance is requested for the first time.
		if (instance == null) {
			instance = new Childrens();
		}
		return instance;
	}

	// This constructor is *private* to ensure no one
	// can instantiate this class
	private Childrens() {
	}
	
	protected double getAmountPerExtraDay() {
		return 1.5;
	}

	protected int getBaseDays() {
		return 3;
	}

	protected double getBaseAmount() {
		return 1.5;
	}	
}

class NewRelease extends PriceCode {
	public static final PriceCode NEW_RELEASE = new NewRelease();

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

class Regular extends PriceCode {
	public static final PriceCode REGULAR = new Regular();

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
			double amount = rental.getPrice();
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ String.valueOf(amount) + "\n";
			totalAmount += amount;
			frequentRenterPoints += rental.getPoints();
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}
}

public class MovieStore {
	public static void main(String[] args) {
		Customer ahmet = new Customer("Ahmet");
		Movie sevenSamurai = new Movie("Seven Samurai", Regular.REGULAR);
		// Childrens price code is a singleton, others are not.
		// This is just to show how Singleton would have been implemented
		Movie corpseBride = new Movie("Corpse Bride", Childrens.getInstance());
		Movie inception = new Movie("Inception", NewRelease.NEW_RELEASE);
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

