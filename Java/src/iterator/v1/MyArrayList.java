package iterator.v1;

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
