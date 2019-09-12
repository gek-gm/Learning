package refactoring;

import java.util.Arrays;
import java.util.List;

public class SubstituteAlgorithmExample {
    
    String foundPerson(String[] people){
        List<String> peopleList = Arrays.asList(new String[] {"Don", "John", "Kent"});
        for (String person : people)
            if (peopleList.contains(person))
                return person;
        return "";
    }
    
}
