package com.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import com.RequestURI;
import com.app.formatter.FormatType;

public class CourseController implements Controller {
    private Context _context;
    private RequestURI _requestURI;

    @Override
    public void execute(Context context) throws IOException, ServletException {
        _context = context;
        _requestURI = new RequestURI(_context.request().getRequestURI());
        _context.response().setContentType("text/html");
        _context.response().setCharacterEncoding("UTF-8");
        handleRequest();
    }
    
    public void handleRequest() throws IOException, ServletException {
       ControllerOperation operation;
       switch( _requestURI.getMainAction() ) {
           case "":
               operation = new CoursesListOperation();
               break;
           case "html":
           case "csv":
           case "raw":
               operation = new FormatCourseAsOperation(FormatType.valueOf(_requestURI.getMainAction().toUpperCase()));
               break;
           case "create":
               operation = new CreateCourseOperation();
               break;
           default:
               operation = new PageNotFoundOperation();
       }
       operation.perform(_context);
    }
}
