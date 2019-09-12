package refactoring;

import java.util.Date;

public class DecomposeConditionalExample {
    private int charge;
    private int _summerRate;
    private int quantity;
    private Date SUMMER_START;
    private Date SUMMER_END;
    private int _winterRate;
    private int _winterServiceCharge;
    
    public int getCharge(Date date) {
        if ( notSummer(date)  )
            charge = winterCharge(quantity);
        else
            charge = summerCharge(quantity);
        return charge;
    }

    public boolean notSummer(Date aDate) {
        return aDate.before(SUMMER_START) || aDate.after(SUMMER_END);
    }
    
    public int winterCharge(int quantity) {
        return quantity * _winterRate + _winterServiceCharge;
    }
    
    public int summerCharge(int quantity) {
        return quantity * _summerRate;
    }
    
}
