package refactoring;

public class MoveMethodExample {
    class Account {
        private AccountType _type;
        private int _daysOverdrawn;
        
        double overdraftCharge() {
            return _type.overdraftCharge(_daysOverdrawn);
        }
        
        double bankCharge() {
            double result = 4.5;
            if (_daysOverdrawn > 0) result += overdraftCharge();
                return result;
        }
    }
    
    abstract class AccountType {
        double overdraftCharge(int daysOverdrawn) {
            if (isPremium()) {
                double result = 10;
                if (daysOverdrawn > 7) result += (daysOverdrawn - 7) * 0.85;
                    return result;
            }
            else 
                return daysOverdrawn * 1.75;
        }
        abstract boolean isPremium();
    }
}
    
