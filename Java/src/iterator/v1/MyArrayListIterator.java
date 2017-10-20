package iterator.v1;

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
