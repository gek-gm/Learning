package com;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.app.controller.Context;
import com.app.controller.Controller;

public class Servlet extends HttpServlet {
	
//	private SQLiteConnectionPoolDataSource _ds;
//	_ds = new SQLiteConnectionPoolDataSource();
//	_ds.setUrl("jdbc:sqlite:/path");
	
//	private HikariDataSource _ds;
//  _ds = new HikariDataSource();
//	_ds.setJdbcUrl("jdbc:sqlite:/path");
	
	private DataSource _ds;
	
	@Override
	public void init(){
		try {
			_ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/ds");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    RequestURI requestURI = new RequestURI(req.getRequestURI());
	    Optional<Controller> controller = ControllerFactory.fromURI(requestURI);
	    if (!controller.isPresent())
	        pageNotFound(req, resp);
        try (Connection connection = _ds.getConnection()) {
            connection.setAutoCommit(false);
            controller.get().execute(new Context(req, resp, connection));
            connection.commit();
            return;
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(e);
        }
    }
	
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    RequestURI requestURI = new RequestURI(req.getRequestURI());
        Optional<Controller> controller = ControllerFactory.fromURI(requestURI);
        if (!controller.isPresent())
            pageNotFound(req, resp);
        try (Connection connection = _ds.getConnection()) {
            connection.setAutoCommit(false);
            controller.get().execute(new Context(req, resp, connection));
            connection.commit();
            return;
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(e);
        }
    }
	
	private void pageNotFound(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/404.jsp");
        rd.forward(req, resp);
	}
	
}
