package refactoring.introduceparameterobject;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class IntroduceParameterObjectExample {
    
    public void clientCode() {
        Date startDate = null;
        Date endDate = null;
        Account anAccount = new Account();
        double flow = anAccount.getFlowBetween(startDate, endDate);
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
    
    class Account{
        private final Vector<Entry> _entries = new Vector<>();
        
        double getFlowBetween (Date start, Date end) {
            double result = 0;
            Enumeration<Entry> e = _entries.elements();
            while (e.hasMoreElements()) {
                Entry each = e.nextElement();
                if (each.getDate().equals(start) || each.getDate().equals(end) 
                || (each.getDate().after(start) && each.getDate().before(end))
                    )
                    result += each.getValue();    
            }
            return result;
        }
    }
    
}
