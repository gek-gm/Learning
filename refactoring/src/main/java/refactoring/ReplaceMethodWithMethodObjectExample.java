package refactoring;

public class ReplaceMethodWithMethodObjectExample {
    class Account {
        int gamma (int inputVal, int quantity, int yearToDate) {
            return new Gamma(this,inputVal, quantity, yearToDate).execute();
        }
        public int delta() {
            return 123;
        }
    }
    
    class Gamma {
        private final Account _account;
        private final int inputVal;
        private final int quantity;
        private final int yearToDate;
        private int importantValue1;
        private int importantValue2;
        private int importantValue3;
        
        public Gamma(Account source, int inputValArg, int quantityArg, int yearToDateArg) {
            _account = source;
            inputVal = inputValArg;
            quantity = quantityArg;
            yearToDate = yearToDateArg;
        }
        
        public int execute() {
            importantValue1 = (inputVal * quantity) + _account.delta();
            importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100)
                importantValue2 -= 20;
            importantValue3 = importantValue2 * 7;
            // -and so on.
            return importantValue3 - 2 * importantValue1;
        }
        
    }
    
}
