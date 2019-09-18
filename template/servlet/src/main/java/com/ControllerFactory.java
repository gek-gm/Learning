package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.app.controller.Controller;
import com.app.controller.CourseController;

public class ControllerFactory {
    
	public static Optional<Controller> fromURI(RequestURI uri) {
	    Map<String,Controller> availableControllers = new HashMap<>();
	    availableControllers.put("course", new CourseController() );
	    return Optional.ofNullable(availableControllers.get(uri.getEntityType()));
	}
	
}
