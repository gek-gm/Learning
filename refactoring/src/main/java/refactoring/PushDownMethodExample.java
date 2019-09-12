package refactoring;

public class PushDownMethodExample {
    
    class Employee{
        
    }
    
    class SalesMan extends Employee{
        private final int _quota = 10;
        
        public int getQuota() {
            return _quota;
        }
    }
    
    class Engineer extends Employee{
        
    }

}
