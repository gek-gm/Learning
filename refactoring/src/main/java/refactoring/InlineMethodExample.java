package refactoring;

public class InlineMethodExample {
    private int _numberOfLateDeliveries;
    
    int getRating() {
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }
    
}
