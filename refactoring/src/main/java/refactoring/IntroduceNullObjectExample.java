package refactoring;

public class IntroduceNullObjectExample {
    
    public void clientCode() {
        Site site = new Site();
        BillingPlan plan;
        Customer customer = site.getCustomer();
        
        if (customer == null)
            plan = BillingPlan.basic();
        else
            plan = customer.getBillingPlan();
        
        String customerName;
        if (customer == null)
            customerName = "occupant";
        else
            customerName = customer.getName();
        
        int weeksDelinquent = 0;
        if (customer == null)
            weeksDelinquent = 0;
        else
            weeksDelinquent = customer.getPaymentHistory().getWeeksDelinquentInLastYear();
        System.out.println(plan + customerName + weeksDelinquent);
    }
    
    class Site{
        private final Customer _customer = null;

        public Customer getCustomer() {
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
        
    }
    
    class PaymentHistory{
        int getWeeksDelinquentInLastYear() {
            return 1;
        }
    }
    
    static class BillingPlan{
        public static  BillingPlan basic() {
            return new BillingPlan();
        }
    }
}
