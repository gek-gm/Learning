package structure;

import java.util.LinkedList;

public class SimpleQueue<T> {
    protected final LinkedList<T> queue = new LinkedList<>();
    protected final int capacity = 100;
    
    public void enqueue(T item){
        if (isFull())
            throw new RuntimeException("Queue is full");
        queue.add(item);
    }
    
    public T dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue.remove();
    }
    
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue.getFirst();
    }
    
    public boolean isFull() {
        return queue.size() == capacity;
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
    
    public int getCapacity() {
        return capacity;
    }
    
}
