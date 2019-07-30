package by.gsu.lab.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.lab.db.ConnectionControl;
import by.gsu.lab.db.DBDataLoader;

@SuppressWarnings("serial")
public class Task4Controller extends AbstractBaseController {
	
	private double max(double x, double y) {
	    if (x < y) {
	        return x;
	    }
	    return x;
	}

	private double min(double x, double y) {
	    if (x > y) {
	        return y;
	    }
	    return x;
	}
	
	private boolean thc(double x, double y, double z, double w, double a, double b)	{
	    double k, c;

	    if (z == x) {
	        return (a == x && b >= min(y, w) && x <= max(y, w));
	    }

	    k = (w - y) / (z - x);
	    c = y - k * x;

	    return b == a * k + c;
	}

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection;
		try {
			request.setCharacterEncoding("UTF-8");
			
			String x1 = request.getParameter("xDot1");
			String y1 = request.getParameter("yDot1");
			String x2 = request.getParameter("xDot2");
			String y2 = request.getParameter("yDot2");
			int X = Integer.parseInt(x1);
			int Y = Integer.parseInt(y1);
			int X2 = Integer.parseInt(x2);
			int Y2 = Integer.parseInt(y2);
			
			connection = ConnectionControl.getConnection();
			DBDataLoader loader = new DBDataLoader();
			
			List<List<String>> task4ResultList = new ArrayList<>();
			List<List<String>> dots = loader.getAllDots(connection);
			for(List<String>dot : dots) {
				int DBx = Integer.parseInt(dot.get(1));
				int DBy = Integer.parseInt(dot.get(2));
				boolean result = thc(X, Y, X2, Y2, DBx, DBy);
				if(result) {
					task4ResultList.add(dot);
				}
			}
			request.setAttribute("task4ResultList", task4ResultList);
			jump("/task4-result.jsp", request, response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			jumpError("/task4.jsp", ex.getMessage(), request, response);
		} finally {
            ConnectionControl.close();
        }
	}
}