package refactoring.decomposeconditional;

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
        if ( date.before(SUMMER_START) || date.after(SUMMER_END)  )
            charge = quantity * _winterRate + _winterServiceCharge;
        else
            charge = quantity * _summerRate;
        return charge;
    }
    
}
