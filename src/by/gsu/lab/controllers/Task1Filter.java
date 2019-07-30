package by.gsu.lab.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import by.gsu.lab.db.ConnectionControl;
import by.gsu.lab.db.DBDataLoader;

public class Task1Filter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		try {
			ConnectionControl.getConnection();

			chain.doFilter(request,response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			chain.doFilter(request,response);
		} finally {
            ConnectionControl.close();
        }
	}

	public void init(FilterConfig fConfig) {
		// TODO Auto-generated method stub
	}
}
