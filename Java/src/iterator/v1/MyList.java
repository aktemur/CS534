package iterator.v1;

interface MyList<T> {
	public void add(T item);
	public int getSize();
	public T get(int i);

	// This is a cleaner interface as opposed to iterator.v0.MyList
	public MyIterator<T> iterator();
	public MyIterator<T> reverseIterator();
}
