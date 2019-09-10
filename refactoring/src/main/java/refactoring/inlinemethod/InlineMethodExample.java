package refactoring.inlinemethod;

public class InlineMethodExample {
    
    int getRating() {
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }
    
}
