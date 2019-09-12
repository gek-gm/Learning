package refactoring;

public class ExtractSubClassExample {
    
    class JobItem {
        private final int _unitPrice;
        protected final int _quantity;
    
        public JobItem (int unitPrice, int quantity) {
            _unitPrice = unitPrice;
            _quantity = quantity;
        }
        
        public int getTotalPrice() {
            return getUnitPrice() * _quantity;
        }
        
        public int getUnitPrice(){
            return _unitPrice;
        }
        
        public boolean isLabor() {
            return false;
        }
        
        public int getQuantity(){
            return _quantity;
        }
    }
    
    class LaborItem extends JobItem {
        private final Employee _employee;
        
        public LaborItem(int quantity, Employee employee) {
            super(0, quantity);
            _employee = employee;
        }
        
        @Override
        public int getUnitPrice() {
            return _employee.getRate();
        }
        
        @Override
        public boolean isLabor() {
            return true;
        }
        
        public Employee getEmployee() {
            return _employee;
        }
    }
    
    class Employee{
        private final int _rate;
        public Employee (int rate) {
            _rate = rate;
        }
        public int getRate() {
            return _rate;
        }
    }

}
