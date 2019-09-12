package refactoring;

import java.util.Vector;

public class ReplaceInheritanceWithDelegationExample {
    
    class MyStack<T> extends Vector<T> {
        
        public void push(T element) {
            insertElementAt(element,0);
        }
        
        public T pop() {
            T result = firstElement();
            removeElementAt(0);
            return result;
        }
    }
}
