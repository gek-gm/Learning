package com;

public class RequestURI {
    private String _entityType = "";
    private String _mainAction = "";
    
    public RequestURI(String requestURI) {
        String[] decomposedURI = requestURI.split("/");
        if (decomposedURI.length >= 2 ) 
            _entityType = decomposedURI[1];
        if (decomposedURI.length >= 3 ) 
            _mainAction = decomposedURI[2];
    }
    
    
    public String getMainAction() {
        return _mainAction;
    }
    
    
    public String getEntityType() {
        return _entityType;
    }
}