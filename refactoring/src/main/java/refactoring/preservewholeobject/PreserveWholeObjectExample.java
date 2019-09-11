package refactoring.preservewholeobject;

public class PreserveWholeObjectExample {
    
    class TempRange {
        private final double _low;
        private final double _high;
        
        public TempRange(double low, double high) {
            _low = low;
            _high = high;
        }
        
        public double getLow() {
            return _low;
        }
        
        public double getHigh() {
            return _high;
        }
    }
    
    class Room{
        boolean withinPlan(HeatingPlan plan) {
            double low = daysTempRange().getLow();
            double high = daysTempRange().getHigh();
            return plan.withinRange(low, high);
        }
        
        private TempRange daysTempRange() {
            return new TempRange(11.5d ,13.2d);
        }   
    }
    
    class HeatingPlan{
        private TempRange _range;
        
        boolean withinRange (double low, double high) {
            return (low >= _range.getLow() && high <= _range.getHigh());
        }
    }
    
}
