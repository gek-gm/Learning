package refactoring.extractmethod;

import java.util.Enumeration;

public class ExtractMethodExample {
    
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
        Enumeration<E> e = _orders.elements();
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }
    
    void printDetails() {
        System.out.println ("name:" + _name);
        System.out.println ("amount" + outstanding);
    }
    
}
