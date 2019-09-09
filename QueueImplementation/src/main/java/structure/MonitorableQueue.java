package structure;

public class MonitorableQueue<T> extends SimpleQueue<T> {
    private int highestSize;
    
    @Override
    public void enqueue(T item){
        if (isFull())
            throw new RuntimeException("Queue is full");
        queue.add(item);
        if (size() > highestSize)
            highestSize = size();
    }
    
    public int getHighestSize() {
        return highestSize;
    }
    
}