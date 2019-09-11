package refactoring.replacedatavaluewithobject;

import java.util.Collection;

public class ReplaceDataValueWithObjectExample {
    
    private static int numberOfOrdersFor(Collection<Order> orders, String customer) {
         int result = 0;
         Iterator iter = orders.iterator();
         while (iter.hasNext()) {
             Order each = (Order) iter.next();
             if (each.getCustomerName().equals(customer)) result++;
         }
         return result;
     }
    
    class Order{
        private String _customer;
        
        public Order (String customer) {
            _customer = customer;
        }
        public String getCustomer() {
            return _customer;
        }
        public void setCustomer(String arg) {
            _customer = arg;
        }
    }
}
