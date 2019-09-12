package refactoring;

public class RemoveSettingMethodExample {
    
    class Account {
        private String _id;
        
        public Account (String id) {
            setId(id);
        }
        
        void setId (String arg) {
            _id = arg;
        }
        String getId () {
            return _id;
        }
    }
}
