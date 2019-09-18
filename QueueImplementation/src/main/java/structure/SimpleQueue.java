package structure;

import java.util.LinkedList;
import java.util.List;

public class SimpleQueue<T> implements MyQueue{
    protected final List<T> queue = new LinkedList<>();
    protected final int capacity = 100;
    
    public void enqueue(T item){
        if (isFull())
            throw new RuntimeException("Queue is full");
        queue.add(item);
    }
    
    public T dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue.remove(0);
    }
    
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue.get(0);
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
