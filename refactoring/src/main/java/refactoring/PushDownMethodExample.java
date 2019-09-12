package refactoring;

public class PushDownMethodExample {
    
    class Employee{
        private final int _quota = 10;
        
        public int getQuota() {
            return _quota;
        }
        
    }
    
    class SalesMan extends Employee{
        
    }
    
    class Engineer extends Employee{
        
    }

}
