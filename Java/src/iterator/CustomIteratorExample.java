package iterator;

import java.util.*;

interface MyList<T> {
	public void add(T item);
	public int getSize();
	public T get(int i);
	public MyIterator<T> iterator();
	public MyIterator<T> reverseIterator();
}

interface MyIterator<T> {
	public boolean hasNext();
	public T next();	
}

class MyArrayList<T> implements MyList<T> {
    private T[] items;
    private int numberOfItems;
    
    public MyArrayList() {
    	this(10);
    }

    public MyArrayList(int initialSize) {
        items = (T[])(new Object[initialSize]);
        numberOfItems = 0; // initially the container is empty
    }
    
    public void add(T newItem) {
        if (numberOfItems == items.length) {
            // no space left. Expand the array
            T[] newItems = (T[])(new Object[items.length * 2]);
            for (int i = 0; i < items.length; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[numberOfItems] = newItem;
        numberOfItems++;
    }
    
    public int getSize() {
        return numberOfItems;
    }
    
    public T get(int i) {
    	return items[i];
    }
    
	public MyIterator<T> iterator() {
		return new MyArrayListIterator<T>(this);
	}

	public MyIterator<T> reverseIterator() {
		return new MyArrayListReverseIterator<T>(this);
	}
}

class MyArrayListIterator<T> implements MyIterator<T> {
	private MyArrayList<T> arrayList;
    private int iterationIndex;

    MyArrayListIterator(MyArrayList<T> arrayList) {
    	this.arrayList = arrayList;
    	iterationIndex = 0;
    }
        
	public boolean hasNext() {
		return iterationIndex < arrayList.getSize();
	}
	
	public T next() {
		return arrayList.get(iterationIndex++);
	}
}

class MyArrayListReverseIterator<T> implements MyIterator<T> {
	private MyArrayList<T> arrayList;
    private int iterationIndex;

    MyArrayListReverseIterator(MyArrayList<T> arrayList) {
    	this.arrayList = arrayList;
    	iterationIndex = arrayList.getSize();
    }
        
	public boolean hasNext() {
		return iterationIndex > 0;
	}
	
	public T next() {
		return arrayList.get(--iterationIndex);
	}
}

public class CustomIteratorExample {
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
	}

	private static void processItems(MyIterator<Integer> iterator) {
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}

