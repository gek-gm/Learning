package refactoring;

public class MoveFieldExample {
    class Account {
        private AccountType _type;
        private double _interestRate;
        double interestForAmount_days (double amount, int days) {
            return _interestRate * amount * days / 365;
        }
        
        public AccountType getType() {
            return _type;
        }
        public void setType(AccountType type) {
            _type = type;
        }
    }
    abstract class AccountType {
        
    }
}
