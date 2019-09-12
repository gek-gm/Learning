package refactoring;

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
        
        public boolean includes(TempRange aTempRange) {
            return (aTempRange.getLow() >= _low && aTempRange.getHigh() <= _high );
        }
    }
    
    class Room{
        boolean withinPlan(HeatingPlan plan) {
            return plan.withinRange(daysTempRange());
        }
        
        private TempRange daysTempRange() {
            return new TempRange(11.5d ,13.2d);
        }
    }
    
    class HeatingPlan{
        private TempRange _range;
        
        boolean withinRange (TempRange aTempRange) {
            return (_range.includes(aTempRange));
        }
    }
    
}
