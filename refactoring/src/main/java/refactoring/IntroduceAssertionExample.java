package refactoring;

import junit.framework.Assert;

public class IntroduceAssertionExample {
    
    class Project{
        double getMemberExpenseLimit() {
            return 1d;
        }
    }
    
    class Employee{
        private static final double NULL_EXPENSE = -1.0;
        private double _expenseLimit = NULL_EXPENSE;
        private Project _primaryProject;
        
        double getExpenseLimit() {
            Assert.assertTrue(_expenseLimit != NULL_EXPENSE || _primaryProject != null);
            return (_expenseLimit != NULL_EXPENSE) ?
            _expenseLimit:
            _primaryProject.getMemberExpenseLimit();
        }
        boolean withinLimit (double expenseAmount) {
            return (expenseAmount <= getExpenseLimit());
        }
        
        public void setExpenseLimit(double limit) {
            _expenseLimit = limit;
        }
    }
}
