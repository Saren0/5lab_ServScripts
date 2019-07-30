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
public class Task3Controller extends AbstractBaseController {

	@Override
	protected void performTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection;

		try {
			request.setCharacterEncoding("UTF-8");
			
			String x = request.getParameter("xDot");
			String y = request.getParameter("yDot");
			int inputX = Integer.parseInt(x);
			int inputY = Integer.parseInt(y);
			
			connection = ConnectionControl.getConnection();
			DBDataLoader loader = new DBDataLoader();
			
			List<List<String>> dots = loader.getAllDots(connection);
			List<String> dotX = new ArrayList<>();
			float maxLength = 0;
			for(List<String> dot : dots) {
				int DBx = Integer.parseInt(dot.get(1));
				int DBy = Integer.parseInt(dot.get(2));
				float stripe = (float) Math.sqrt(((inputX - DBx) * (inputX - DBx)) + ((inputY - DBy) * (inputY - DBy)));  
				if (stripe > maxLength) {
					maxLength = stripe;
					dotX = dot;
				}
			}
			List<List<String>> task3ResultList = new ArrayList<>();
			task3ResultList.add(dotX);
			request.setAttribute("task3ResultList", task3ResultList);

			jump("/task3-result.jsp", request, response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			jumpError("/index.jsp", ex.getMessage(), request, response);
		} finally {
            ConnectionControl.close();
        }
	}
}