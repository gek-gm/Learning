package refactoring.replacetypecodewithclass;

public class ReplaceTypeCodeWithClassExample {
    
    class Person {
        private BloodGroup _bloodGroup;
        
        public Person (BloodGroup bloodGroup) {
            _bloodGroup = bloodGroup;
        }
        
        public void setBloodGroup(BloodGroup bloodGroup) {
            _bloodGroup = bloodGroup;
        }
        
        public BloodGroup getBloodGroup() {
            return _bloodGroup;
        }
    }
    
    enum BloodGroup {
        ZERO(0),
        A(1),
        B(2),
        AB(3);
        
        private final int _code;

        BloodGroup(int code) {
            _code = code;
        }
        
        public int getCode() {
            return _code;
        }
        
        public BloodGroup getByCode(int code) {
            for (BloodGroup b : BloodGroup.values())
                if (b.getCode() == code)
                    return b;
            return null;
        }
    }
}
