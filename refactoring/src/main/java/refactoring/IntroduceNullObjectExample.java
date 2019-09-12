package refactoring;

public class IntroduceNullObjectExample {
    
    public void clientCode() {
        Site site = new Site();
        BillingPlan plan;
        Customer customer = site.getCustomer();
        
        if (customer.isNull())
            plan = BillingPlan.basic();
        else
            plan = customer.getBillingPlan();
        
        String customerName = customer.getName();
        
        int weeksDelinquent = customer.getPaymentHistory().getWeeksDelinquentInLastYear();
        
        System.out.println(plan + customerName + weeksDelinquent);
    }
    
    class Site{
        private final Customer _customer = null;

        public Customer getCustomer() {
            if (_customer == null)
                return new NullCustomer();
            return _customer;
        }
    }
    
    class Customer{
        private String _name;
        private BillingPlan _billingPlan;
        private PaymentHistory _paymentHistory;
        
        public String getName() {
            return _name;
        }
        
        public BillingPlan getBillingPlan() {
            return _billingPlan;
        }
        
        public PaymentHistory getPaymentHistory() {
            return _paymentHistory;
        }
        
        public boolean isNull() {
            return false;
        }
        
    }
    
    class NullCustomer extends Customer {
        
        @Override
        public boolean isNull() {
            return true;
        }
        @Override
        public String getName() {
            return "occupant";
        }
        
        @Override
        public PaymentHistory getPaymentHistory() {
            return new NullPaymentHistory();
        }
    }
    
    class PaymentHistory{
        int getWeeksDelinquentInLastYear() {
            return 1;
        }
    }
    
    class NullPaymentHistory extends PaymentHistory{
        @Override
        int getWeeksDelinquentInLastYear() {
            return 0;
        }
    }
    
    static class BillingPlan{
        public static  BillingPlan basic() {
            return new BillingPlan();
        }
    }
}
