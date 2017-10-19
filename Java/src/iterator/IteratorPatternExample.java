package iterator;

import java.util.*;

public class IteratorPatternExample {
	public static void main(String[] args) {
		Set<Integer> integers = new HashSet<Integer>();
		integers.add(12);
		integers.add(15);
		integers.add(9);
		integers.add(2);
		integers.add(18);
		integers.add(5);		
		printElements(integers);
	}

	private static void printElements(Collection<Integer> numbers) {
		Iterator<Integer> it = numbers.iterator();
		while(it.hasNext()) {
			Integer integer = it.next();
			System.out.print(integer + " ");
		}
		
//		// Syntactic sugar for the code above
//		for(Integer i: numbers) {
//			System.out.print(i + " ");
//		}
	}
}
