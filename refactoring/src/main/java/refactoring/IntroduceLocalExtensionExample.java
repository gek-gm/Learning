package refactoring;

import java.util.Date;

public class IntroduceLocalExtensionExample {
    Date aDate;
    
    public void clientCode() {
        Date newStart = nextDay(aDate);
        System.out.println(newStart);
    }
    
    public static Date nextDay(Date start) {
        return new Date(start.getYear(),start.getMonth(), start.getDate() + 1);
    }
    
    class dateSub extends Date {
        
        public dateSub(Date aDate) {
            super(aDate.getTime());
        }
        
        public dateSub(String dateString) {
            super(dateString);
        }
        
        public Date nextDay() {
            return new Date(getYear(),getMonth(), getDate() + 1);
        }
    }
}
