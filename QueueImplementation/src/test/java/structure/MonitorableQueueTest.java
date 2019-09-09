package structure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MonitorableQueueTest {
    MonitorableQueue<String> queue = new MonitorableQueue<>();
    
    @Before
    public void setUpQueue() {
        queue = new MonitorableQueue<>();
    }
    
    private void enqueueElements(int howMany) {
        String element;
        for (int i = 0; i < howMany; i++) {
            element = "My String " + i;
            queue.enqueue(element);
        }
    }

    @Test
    public void whenOneElementIsAdded_expectItReturnsOnDequeue() {
        String element = "My String to Enqueue";
        queue.enqueue(element);
        
        assertTrue(queue.dequeue() == element);
    }
    
    @Test
    public void whenMultipleElementsAreAdded_expectTheyDequeueInTheCorrectOrder() {
        String first = "First Queue Element";
        String second = "Second Queue Element";
        String third = "Third Queue Element";
        
        queue.enqueue(first);
        queue.enqueue(second);
        queue.enqueue(third);
        
        assertTrue(queue.dequeue() == first);
        assertTrue(queue.dequeue() == second);
        assertTrue(queue.dequeue() == third);
    }
    
    @Test
    public void whenMultipleElementsAreAdded_expectFirstAddedIsPeeked() {
        String first = "First Queue Element";
        String second = "Second Queue Element";
        String third = "Third Queue Element";
        
        queue.enqueue(first);
        queue.enqueue(second);
        queue.enqueue(third);
        
        assertTrue(queue.peek() == first);
    }
    
    @Test
    public void whenOneElementIsAdded_expectElementAddedIsPeeked() {
        String first = "My first String to Enqueue";        
        queue.enqueue(first);
        
        assertTrue(queue.peek() == first);
    }
    
    @Test
    public void whenMultipleElementsAreAdded_expectQueueSizeIsCorrect() {
        String first = "First Queue Element";
        String second = "Second Queue Element";
        String third = "Third Queue Element";
        
        queue.enqueue(first);
        queue.enqueue(second);
        queue.enqueue(third);
        
        assertEquals(3, queue.size());
    }
    
    @Test
    public void whenMultipleElementsAreAdded_expectHighest() {
        String first = "First Queue Element";
        String second = "Second Queue Element";
        String third = "Third Queue Element";
        
        queue.enqueue(first);
        queue.enqueue(second);
        queue.enqueue(third);
        
        assertEquals(3, queue.size());
    }
    
    @Test
    public void whenQueueIsEmpty_expectQueueSizeIsCorrect() {
        assertEquals(0, queue.size());
    }
    
    @Test(expected = RuntimeException.class)
    public void whenQueueIsFull_expectExceptionIsThrownOnEnqueue() {
       enqueueElements(queue.getCapacity());
       queue.enqueue("This one does not fit");
    }
    
    @Test(expected = RuntimeException.class)
    public void whenQueueIsEmpty_expectExceptionIsThrownOnDequeue(){
       queue.dequeue();
    }
    
    @Test(expected = RuntimeException.class)
    public void whenQueueIsEmpty_expectExceptionIsThrownOnPeek(){
       queue.peek();
    }
    
    @Test
    public void whenMultipleElementsAreAdded_expectHighestMaxValueIsCorrect(){
        String first = "First Queue Element";
        String second = "Second Queue Element";
        String third = "Third Queue Element";
        
        queue.enqueue(first);
        queue.enqueue(second);
        queue.enqueue(third);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Yet Another String");
        
        assertEquals(3, queue.getHighestSize());
    }
}
