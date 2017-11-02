package iterator.v1;

public class Main {
	public static void main(String[] args) {
		MyList<Integer> myintegers = new MyArrayList<Integer>();
		myintegers.add(12);
		myintegers.add(15);
		myintegers.add(9);
		myintegers.add(2);
		myintegers.add(18);
		myintegers.add(5);
		
		processItems(myintegers.iterator());
		processItems(myintegers.reverseIterator());

		// Simultaneous iteration is OK
		MyIterator<Integer> outer = myintegers.iterator();
		while(outer.hasNext()) {
			System.out.print(outer.next() + ": ");
			MyIterator<Integer> inner = myintegers.iterator();
			while(inner.hasNext()) {
				System.out.print(inner.next() + ", ");
			}
			System.out.println();
		}
	}

	// We do not need to duplicate code as processItemsForward and processItemsBackward.
    // Backward and forward iterators implement the same interface.
	private static void processItems(MyIterator<Integer> iterator) {
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}

