package mvc.die;

import java.util.Random;

// This is the model class that
// defines a die. A die object can be rolled,
// and can be queried for its face value.
// The face value is in the range [1, numFaces]
public class Die {
	private int numFaces;
	private int faceValue;
	private Random randomGenerator;
	
	public Die() {
		this(6);
	}
	
	public Die(int numFaces) {
		this.numFaces = numFaces;
		this.randomGenerator = new Random();
		roll();
	}
	
	public void roll() {
		faceValue = randomGenerator.nextInt(numFaces) + 1;
	}
	
	public int getFaceValue() {
		return faceValue;
	}
}









