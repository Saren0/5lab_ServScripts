package by.gsu.lab.controllers;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import by.gsu.lab.db.*;

@SuppressWarnings("serial")
public class InsertDotsCoordinates extends AbstractBaseController {
 
	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String x = request.getParameter("xDot");
			String y = request.getParameter("yDot");
			int x1 = Integer.parseInt(x);
			int y1 = Integer.parseInt(y);
			doInsertDots(x1, y1);
			jump("/ViewDataController", request, response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			jumpError("/index.jsp", ex.getMessage(), request, response);
		}
	}

	private void doInsertDots(int x, int y) 
			throws SQLException, ClassNotFoundException {
		Connection connection;
		try {
			connection = ConnectionControl.getConnection();
	    	new DBDataSetter().insertDots(connection, x, y);
		} finally {
            ConnectionControl.close();
        }
	}
}
