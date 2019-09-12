package refactoring;

public class MoveFieldExample {
    
    class Account {
        private AccountType _type;
        
        double interestForAmount_days (double amount, int days) {
            return _type.getInterestRate() * amount * days / 365;
        }
        
        public AccountType getType() {
            return _type;
        }
        public void setType(AccountType type) {
            _type = type;
        }
    }
    
    abstract class AccountType {
        private double _interestRate;

        public double getInterestRate() {
            return _interestRate;
        }

        public void setInterestRate(double interestRate) {
            _interestRate = interestRate;
        }    
    }
    
}
