package refactoring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChangeBidirectionalAssociationToUnidirectionalExample {
    
    class Order{
        
        Customer getCustomer() {
            for (Customer customer : Customer.getInstances())
                if(customer.friendOrders().contains(this))
                    return customer;
            return null;
                    
        }
        
        void setCustomer (Customer arg) {
            if (arg != null)
                if (getCustomer() != null) { 
                    getCustomer().friendOrders().remove(this);
                    arg.friendOrders().add(this);
                }
        }
    }
    
    static class Customer{
        private final Set<Order> _orders = new HashSet<>();
        
        void addOrder(Order arg) {
            arg.setCustomer(this);
        }
        
        public Set<Order> friendOrders() {
            /** should only be used by Order */
            return _orders;
        }
        
        public static List<Customer> getInstances() {
            return new ArrayList<>();
        }
    }
}
