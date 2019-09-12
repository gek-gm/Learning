package refactoring;

public class InlineClassExample {
    
    class Person {
        private final TelephoneNumber _officeTelephone = new TelephoneNumber();
        private String _name;
        
        public TelephoneNumber getOfficeTelephone() {
            return _officeTelephone;
        }
        public String getName() {
            return _name;
        }
        public String getTelephoneNumber() {
            return _officeTelephone.getTelephoneNumber();
        }
    }
    
    class TelephoneNumber{
        private String _areaCode;
        private String _number;
        
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
