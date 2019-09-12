package refactoring;

import java.util.Date;

public class IntroduceForeignMethodExample {
    Date previousEnd;
    
    public void clientCode() {
        Date newStart = new Date(previousEnd.getYear(),
            previousEnd.getMonth(), previousEnd.getDate() + 1);
        System.out.println(newStart);
    }
    
}
