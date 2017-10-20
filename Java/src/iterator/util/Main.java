package iterator.util;

import java.util.*;

public class Main {
	public static void main(String[] args) {
	    Set<Integer> integers = new HashSet<Integer>();
//        Set<Integer> integers = new TreeSet<Integer>();
//        List<Integer> integers = new ArrayList<Integer>();
//        List<Integer> integers = new LinkedList<Integer>();
        integers.add(12);
		integers.add(15);
		integers.add(9);
		integers.add(2);
		integers.add(18);
		integers.add(5);		
		printElements(integers);
	}

	private static void printElements(Collection<Integer> numbers) {
		for(Integer number: numbers) {
			System.out.print(number + " ");
		}

		System.out.println();

		// The code above compiles down to this:
		Iterator<Integer> it = numbers.iterator();
		while(it.hasNext()) {
			Integer number = it.next();
			System.out.print(number + " ");
		}
		
	}
}
