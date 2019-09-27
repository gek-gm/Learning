package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import com.app.formatter.FormatType;
import com.app.formatter.Formatter;
import com.app.formatter.seminar.SeminarFormatterFactory;
import com.app.model.Course;
import com.app.model.Seminar;
import com.app.model.dao.CourseDao;

public interface ControllerOperation {
    public void perform(Context context) throws ServletException, IOException;
}

class CreateCourseViewOperation implements ControllerOperation {
    @Override
    public void perform(Context context) throws ServletException, IOException {
        RequestDispatcher rd = context.request().getRequestDispatcher("/jsp/create_course.jsp");
        rd.forward(context.request(), context.response() );
    }
}

class CreateCourseOperation implements ControllerOperation {
    @Override
    public void perform(Context context) throws ServletException, IOException {
        RequestDispatcher rd = context.request().getRequestDispatcher("/jsp/create_course.jsp");
        rd.forward(context.request(), context.response() );
    }
}

class FormatCourseAsOperation implements ControllerOperation {
    private final FormatType _formatType;
    
    public FormatCourseAsOperation(FormatType formatType){
        _formatType = formatType;
    }
    
    @Override
    public void perform(Context context){
        try {
            Seminar seminar = Seminar.getDummyInstance();
            Formatter<Seminar> formatter = SeminarFormatterFactory.fromType( _formatType );
            context.response().getWriter().write(formatter.format(seminar));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class PageNotFoundOperation implements ControllerOperation {
    @Override
    public void perform(Context context) {
        try {
            RequestDispatcher rd = context.request().getRequestDispatcher("/jsp/404.jsp");
            rd.forward(context.request(), context.response());
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class CoursesListOperation implements ControllerOperation {
    @Override
    public void perform(Context context) throws ServletException, IOException {
        CourseDao courseDAO = new CourseDao();
        List<Course> courses =  courseDAO.getAll();
        context.request().setAttribute("courses", courses);
        context.request().getRequestDispatcher("/jsp/courses_list.jsp").forward(context.request(), context.response());
    }
    
}