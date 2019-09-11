package refactoring.replacedatavaluewithobject;

import java.util.Collection;

public class ReplaceDataValueWithObjectExample {
    
    public static int numberOfOrdersFor(Collection<Order> orders, Customer customer) {
         int result = 0;
         for (Order order : orders)
             if (order.getCustomer().equals(customer))
                 result++;
         return result;
     }
    
    class Order{
        private Customer _customer;
        
        public Order (Customer customer) {
            _customer = customer;
        }
        public Customer getCustomer() {
            return _customer;
        }
        public void setCustomer(Customer customer) {
            _customer = customer;
        }
    }
    
    class Customer {
        private final String _name;
        
        public Customer(String name) {
            _name = name;
        }
        
        public String getName() {
            return _name;
        }
    }
    
}
