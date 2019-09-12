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
}
