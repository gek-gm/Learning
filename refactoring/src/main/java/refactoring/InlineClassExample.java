package refactoring;

public class InlineClassExample {
    
    class Person {
        private String _name;
        private String _areaCode;
        private String _number;
        
        public String getName() {
            return _name;
        }
        
        public String getTelephoneNumber() {
            return "(" + _areaCode + ") " + _number; 
        }
        
        public String getAreaCode() {
            return _areaCode;
        }
        public void setAreaCode(String areaCode) {
            _areaCode = areaCode;
        }
        public String getNumber() {
            return _number;
        }
        public void setNumber(String number) {
            _number = number;
        }
    }
}
