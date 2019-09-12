package refactoring;

import java.util.Date;

public class IntroduceForeignMethodExample {
    Date start;
    
    public void clientCode() {
        Date newStart = nextDay(start);
        System.out.println(newStart);
    }
    
    public static Date nextDay(Date start) {
        return new Date(start.getYear(),start.getMonth(), start.getDate() + 1);
    }
    
}
