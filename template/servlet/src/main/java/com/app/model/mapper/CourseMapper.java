package com.app.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.model.Course;

public class CourseMapper {
    
    public static List<Course> fromResultSet(ResultSet rs) throws NumberFormatException, SQLException, ParseException {
        List<Course> courses = new ArrayList<>();
        
        while( rs.next() ) {
            String courseName = rs.getString("name");
            String courseDesc = rs.getString("description");
            int courseNumber = Integer.parseInt(rs.getString("number"));
            String courseStartDate = rs.getString("startDate");
            Date startDate;
            try {
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                startDate = df.parse(courseStartDate);
            } catch(Exception e) {
                startDate = null;
            }
            courses.add(new Course( courseName, courseDesc, courseNumber, startDate));
        }
        
        return courses;
    } 
}
