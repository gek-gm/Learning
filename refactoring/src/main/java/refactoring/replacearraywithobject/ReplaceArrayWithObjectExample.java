package refactoring.replacearraywithobject;

public class ReplaceArrayWithObjectExample {
    public void performance() {
        Performance performance = new Performance();
        performance.setName("Liverpool");
        performance.setWins(15);
        performance.setLosses(7);
    }
    
    public class Performance {
        private String _name;
        private int _wins;
        private int _losses;
        
        public String getName() {
            return _name;
        }
        
        public void setName(String name) {
            _name = name;
        }
        
        public int getWins() {
            return _wins;
        }
        
        public void setWins(int wins) {
            _wins = wins;
        }
        
        public int getLosses() {
            return _losses;
        }
        
        public void setLosses(int losses) {
            _losses = losses;
        }
    }
}
