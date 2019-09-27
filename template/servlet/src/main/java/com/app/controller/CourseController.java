package com.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import com.RequestURI;
import com.app.formatter.FormatType;

public class CourseController implements Controller {
    private Context _context;
    private RequestURI _requestURI;
    private OperationDispatcher _dispatcher;

    @Override
    public void executePost(Context context) throws IOException, ServletException {
        init(context);
        _dispatcher = new PostOperationDispatcher();
        _dispatcher.getOperation(_requestURI).perform(_context);
    }
    
    @Override
    public void executeGet(Context context) throws IOException, ServletException {
        init(context);
        _dispatcher = new GetOperationDispatcher();
        _dispatcher.getOperation(_requestURI).perform(_context);
    }
    
    private void init(Context context) {
        _context = context;
        _requestURI = new RequestURI(_context.request().getRequestURI());
        _context.response().setContentType("text/html");
        _context.response().setCharacterEncoding("UTF-8");
    }
    
    private static class GetOperationDispatcher implements OperationDispatcher {
        
        @Override
        public ControllerOperation getOperation(RequestURI requestURI) {
            switch( requestURI.getMainAction() ) {
                case "":
                    return new CoursesListOperation();
                case "html":
                case "csv":
                case "raw":
                    return new FormatCourseAsOperation(FormatType.valueOf(requestURI.getMainAction().toUpperCase()));                    
                case "create":
                    return new CreateCourseViewOperation();
                default:
                    return new PageNotFoundOperation();
            }
        }
    }
    
    private static class PostOperationDispatcher implements OperationDispatcher {
        
        @Override
        public ControllerOperation getOperation(RequestURI requestURI) {
            switch( requestURI.getMainAction() ) {                    
                case "create":
                    return new CreateCourseViewOperation();
                default:
                    return new PageNotFoundOperation();
            }
        }
    }
    
}
