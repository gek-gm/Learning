package refactoring;

public class ReplaceParameterWithExplicitMethods {
    
    static class Employee{
        static Engineer createEngineer() {
            return new Engineer();
        }
        static Manager createManager() {
            return new Manager();        
        }
        static SalesMan createSalesMan() {
            return new SalesMan();
        }
    }
    
    static class Engineer extends Employee {    
    
    }
    
    static class Manager extends Employee {
        
    }
    
    static class SalesMan extends Employee {
        
    }
}
