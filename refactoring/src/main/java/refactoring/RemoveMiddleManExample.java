package refactoring;

public class RemoveMiddleManExample {
    
    public void clientCode() {
        Person person = new Person();
        Person manager = person.getDepartment().getManager();
        String chargeCode = person.getDepartment().getChargeCode();
        System.out.println(manager + chargeCode);
    }
    
    class Person {
        Department _department;
        
        public Department getDepartment() {
            return _department;
        }
        public void setDepartment(Department arg) {
            _department = arg;
        }
    }
    
    class Department {
        private String _chargeCode;
        
        private final Person _manager;
        
        public Department (Person manager) {
            _manager = manager;
        }
        
        public Person getManager() {
            return _manager;
        }
        
        public String getChargeCode() {
            return _chargeCode;
        }
        
        public void setChargeCode(String chargeCode) {
            _chargeCode = chargeCode;
        }
    }

}
