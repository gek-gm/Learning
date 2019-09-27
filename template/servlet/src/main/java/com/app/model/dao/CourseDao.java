package com.app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import com.app.model.Course;
import com.app.model.mapper.CourseMapper;

public class CourseDao implements Dao<Course> {
    
    @Override
    public List<Course> getAll(){
        try {
            Statement stmt = Dao.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT number, name, description, startDate FROM course");
            List<Course> courses = CourseMapper.fromResultSet(rs);
            return courses;
        } catch (SQLException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Course course) {
        try {
            Connection conn = Dao.getConnection();
            String query = "INSERT INTO course(name, description, number, startDate VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDescription());
            stmt.setInt(3, course.getNumber());
            stmt.setString(4, course.getStartDateAsString() );
            stmt.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
