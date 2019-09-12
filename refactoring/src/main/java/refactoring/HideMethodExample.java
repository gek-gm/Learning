package refactoring;

import java.util.ArrayList;
import java.util.List;

public class HideMethodExample {
    
    class Coffee {
        
    }
    
    class CoffeMachine{
        private double _waterTemperature;
        private final List<String> ingredients = new ArrayList<>(); 
        
        public Coffee prepareCoffee() {
            heatWater();
            pourCoffee();
            return new Coffee();
        }
        
        void heatWater(){
            _waterTemperature = 100d;
        }
        
        void pourCoffee(){
            if (_waterTemperature == 100d)
                ingredients.add("coffee");
        }
        
    }
}
