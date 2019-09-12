package refactoring;

import java.util.Vector;

public class ReplaceInheritanceWithDelegationExample {
    
    class MyStack<T> {
        private final Vector<T> _vector = new Vector<>();
        
        public void push(T element) {
            _vector.insertElementAt(element,0);
        }
        
        public T pop() {
            T result = _vector.firstElement();
            _vector.removeElementAt(0);
            return result;
        }
    }
}
