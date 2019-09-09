package structure;

public interface Queue<T> {
    
    public void enqueue(T item);
    public T dequeue();
    public T peek();
    public boolean isFull();
    public boolean isEmpty();
    public int size();
    public int getCapacity();
    
}
