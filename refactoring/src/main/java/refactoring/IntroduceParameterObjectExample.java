package refactoring;

import java.util.Date;
import java.util.Vector;

public class IntroduceParameterObjectExample {
    
    public void clientCode() {
        Date startDate = null;
        Date endDate = null;
        Account anAccount = new Account();
        DateRange dateRange = new DateRange(startDate, endDate);
        double flow = anAccount.getFlowBetween(dateRange);
        System.out.println(flow);
    }
    
    class Entry {
        private final double _value;
        private final Date _chargeDate;
        
        public Entry (double value, Date chargeDate) {
            _value = value;
            _chargeDate = chargeDate;
        }
        
        Date getDate(){
            return _chargeDate;
        }
        
        double getValue(){
            return _value;
        }
    }
    
    class Account {
        private final Vector<Entry> _entries = new Vector<>();
        
        double getFlowBetween (DateRange range) {
            double result = 0;
            for (Entry each : _entries )
                if ( range.includes(each.getDate()) )
                    result += each.getValue();
            return result;
        }
    }
    
    class DateRange {
        private final Date _from;
        private final Date _to;
        
        public DateRange(Date from, Date to) {
            _from = from;
            _to = to;
        }
        
        public boolean includes(Date aDate) {
            if (aDate.equals(_from) || aDate.equals(_to) || 
                (aDate.after(_from) && aDate.before(_to)) )
                return true;
            return false;
        }
    }
    
}
