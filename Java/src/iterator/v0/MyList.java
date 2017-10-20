package iterator.v0;

interface MyList<T> {
	public void add(T item);
	public int getSize();
	public T get(int i);

	// Methods below are related to traversal
	public void resetForward();
	public T nextForward();
	public boolean hasNextForward();
    public void resetBackward();
    public T nextBackward();
    public boolean hasNextBackward();
}
