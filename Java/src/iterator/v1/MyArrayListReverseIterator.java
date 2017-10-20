package iterator.v1;

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
