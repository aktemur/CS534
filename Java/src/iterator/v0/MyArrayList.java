package iterator.v0;

class MyArrayList<T> implements MyList<T> {
    private T[] items;
    private int numberOfItems;
    private int nextItemIndex;

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

    public void resetForward() {
        nextItemIndex = 0;
    }

    public T nextForward() {
        return items[nextItemIndex++];
    }

    public boolean hasNextForward() {
        return nextItemIndex < numberOfItems;
    }

    public void resetBackward() {
        nextItemIndex = numberOfItems;
    }

    public T nextBackward() {
        return items[--nextItemIndex];
    }

    public boolean hasNextBackward() {
        return nextItemIndex > 0;
    }
}
