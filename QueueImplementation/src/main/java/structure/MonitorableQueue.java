package structure;

public class MonitorableQueue<T> implements MyQueue {
    private int highestSize;
    private final MyQueue _queue;
        
    public MonitorableQueue(MyQueue queue) {
        _queue = queue;
    }
    
    public T peek() {
        _queue.peek();
    }
    
    @Override
    public void enqueue(T item){
        _queue.enqueue(item);
        highestSize = Math.max(highestSize, _queue.size());
    }
    
    public int getHighestSize() {
        return highestSize;
    }
    
}