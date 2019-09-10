package refactoring.inlinemethod;

public class InlineMethodExample {
    
    int getRating() {
        return (moreThanFiveLateDeliveries()) ? 2 : 1;
    }
    
    boolean moreThanFiveLateDeliveries() {
        return _numberOfLateDeliveries > 5;
    }
    
}
