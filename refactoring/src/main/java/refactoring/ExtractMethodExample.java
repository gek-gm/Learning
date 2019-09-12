package refactoring;

import java.util.Vector;

public class ExtractMethodExample {
    private final String _name = "Mike";
    private final double previousAmount = 3.0;
    Vector<Order> _orders = new Vector<>();
    
    void printOwing() {
        double outstanding = previousAmount * 1.2;
        printBanner();
        outstanding = getOutstanding(outstanding);
        printDetails(outstanding);
    }
    
    void printBanner() {
        System.out.println ("**************************");
        System.out.println ("***** Customer Owes ******");
        System.out.println ("**************************");
    }
    
    double getOutstanding(double initialOutstanding) {
        double result = initialOutstanding;
        for (Order order : _orders)
            result += order.getAmount();
        
        return result;
    }
    
    void printDetails(double outstanding) {
        System.out.println ("name:" + _name);
        System.out.println ("amount" + outstanding);
    }
    
    static class Order {
        public double getAmount() {
            return 6.7;
        }
    }
    
}
