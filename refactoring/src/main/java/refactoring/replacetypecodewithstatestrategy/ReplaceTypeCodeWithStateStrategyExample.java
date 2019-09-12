package refactoring.replacetypecodewithstatestrategy;

public class ReplaceTypeCodeWithStateStrategyExample {
    
    class Employee {
        private final int _type;
        private final int _monthlySalary;
        private final int _commission;
        private final int _bonus;
        static final int ENGINEER = 0;
        static final int SALESMAN = 1;
        static final int MANAGER = 2;
        
        public Employee (int type) {
            _type = type;
            _monthlySalary = 100;
            _commission = 100;
            _bonus = 100;
        }
        int payAmount() {
            switch (_type) {
            case ENGINEER:
            return _monthlySalary;
            case SALESMAN:
            return _monthlySalary + _commission;
            case MANAGER:
            return _monthlySalary + _bonus;
            default:
            throw new RuntimeException("Incorrect Employee");
            }
        }
    }
}
