package structure;
import java.util.LinkedList;

public class MonitorableQueue<T> implements Queue<T> {
    private final LinkedList<T> queue = new LinkedList<>();
    private final int capacity = 100;
    private int highestSize;
    
    @Override
    public void enqueue(T item){
        if (isFull())
            throw new RuntimeException("Queue is full");
        queue.add(item);
        monitorSize();
    }
    
    @Override
    public T dequeue() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue.remove();
    }
    
    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue.getFirst();
    }
    
    @Override
    public boolean isFull() {
        return queue.size() == capacity;
    }
    
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    @Override
    public int size() {
        return queue.size();
    }
    
    private void monitorSize() {
        if (size() > highestSize)
            highestSize = size();
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
    
    public int getHighestSize() {
        return highestSize;
    }
    
}
