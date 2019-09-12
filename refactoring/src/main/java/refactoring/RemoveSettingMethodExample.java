package refactoring;

public class RemoveSettingMethodExample {
    
    class Account {
        private final String _id;
        
        public Account(String id) {
            _id = initializeId(id);
        }
        
        private String initializeId(String arg) {
            return "ZZZ" + arg;
        }
        String getId () {
            return _id;
        }
    }
}
