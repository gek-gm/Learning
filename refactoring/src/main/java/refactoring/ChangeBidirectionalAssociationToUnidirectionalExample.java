package refactoring;

import java.util.HashSet;
import java.util.Set;

public class ChangeBidirectionalAssociationToUnidirectionalExample {
    
    class Order{
        private Customer _customer;
        
        Customer getCustomer() {
            return _customer;
        }
        
        void setCustomer (Customer arg) {
            if (_customer != null) 
                _customer.friendOrders().remove(this);
            _customer = arg;
            if (_customer != null) 
                _customer.friendOrders().add(this);
        }
    }
    
    class Customer{
        private final Set<Order> _orders = new HashSet<>();
        
        void addOrder(Order arg) {
            arg.setCustomer(this);
        }
        
        public Set<Order> friendOrders() {
            /** should only be used by Order */
            return _orders;
        }
    }
}
