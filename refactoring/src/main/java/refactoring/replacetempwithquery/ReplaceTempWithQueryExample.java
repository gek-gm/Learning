package refactoring.replacetempwithquery;

public class ReplaceTempWithQueryExample {
    private double _quantity;
    private double _itemPrice;
    
    public double getBasePrice() {
        double basePrice = _quantity * _itemPrice;
        if (basePrice > 1000)
            return basePrice * 0.95;
        else
            return basePrice * 0.98;
    }

}
