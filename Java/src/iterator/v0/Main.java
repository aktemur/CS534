package iterator.v0;

public class Main {
	public static void main(String[] args) {
		MyList<Integer> myintegers = new MyArrayList<Integer>();
		myintegers.add(12);
		myintegers.add(15);
		myintegers.add(9);
		myintegers.add(2);
		myintegers.add(18);
		myintegers.add(5);

		processItemsForward(myintegers);
        processItemsBackward(myintegers);
	}

	private static void processItemsForward(MyList<Integer> numbers) {
		numbers.resetForward();
		while(numbers.hasNextForward()) {
			System.out.print(numbers.nextForward() + " ");
		}
		System.out.println();
	}

    private static void processItemsBackward(MyList<Integer> numbers) {
        numbers.resetBackward();
        while(numbers.hasNextBackward()) {
            System.out.print(numbers.nextBackward() + " ");
        }
        System.out.println();
    }
}

