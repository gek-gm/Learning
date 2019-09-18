<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.app.model.Course"%>
<% 
List<Course> courses = (ArrayList<Course>) request.getAttribute("courses");
for (Course course : courses) {%>	
        <h1><%= course.getName() %></h1>
        Description: <%= course.getDescription() %></br>
        Number: <%= course.getNumber() %></br>
        Date: <%= course.getStartDateAsString() %></br>
<% } %>