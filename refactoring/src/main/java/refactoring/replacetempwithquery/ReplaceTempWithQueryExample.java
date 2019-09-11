package refactoring.replacetempwithquery;

public class ReplaceTempWithQueryExample {
    private double _quantity;
    private double _itemPrice;
    
    public double getBasePrice() {
        if (basePrice() > 1000)
            return basePrice() * 0.95;
        else
            return basePrice() * 0.98;
    }
    
    public double basePrice() {
        return _quantity * _itemPrice;
    }

}
