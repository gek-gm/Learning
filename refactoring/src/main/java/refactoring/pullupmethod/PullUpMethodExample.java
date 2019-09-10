package refactoring.pullupmethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PullUpMethodExample {
    
    class Customer {
        private final List<Bill> bills = new ArrayList<Bill>();
        protected Date _lastBillDate;
        
        void addBill(Date date, double amount) {
            _lastBillDate = date;
            bills.add(new Bill(date, amount));
        }
    }
    
    class RegularCustomer extends Customer {
        
        void createBill(Date date) {
            double chargeAmount = chargeFor(_lastBillDate, date);
            addBill(date, chargeAmount);
        }
        
        private double chargeFor(Date from, Date to) {
            long diffInMillies = Math.abs(to.getTime() - from.getTime());
            return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) * 12.5;
        }
    }
    
    class PreferredCustomer extends Customer {
        void createBill(Date date) {
            double chargeAmount = chargeFor(_lastBillDate, date);
            addBill(date, chargeAmount);
        }
        
        private double chargeFor(Date from, Date to) {
            long diffInMillies = Math.abs(to.getTime() - from.getTime());
            return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) * 8.5;
        }
    }
    
    class Bill{
        private final double _amount;
        private final Date _date;
        
        public Bill(Date date, double amount) {
            _amount = amount;
            _date = date;
        }

        public double getAmount() {
            return _amount;
        }

        public Date getDate() {
            return _date;
        }
    }
    
}
