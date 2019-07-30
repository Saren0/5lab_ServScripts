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
public class Task1Controller extends AbstractBaseController {

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
			float minLength = 999;
			for(List<String> dot : dots) {
				int DBx = Integer.parseInt(dot.get(1));
				int DBy = Integer.parseInt(dot.get(2));
				float stripe = (float) Math.sqrt(((inputX - DBx) * (inputX - DBx)) + ((inputY - DBy) * (inputY - DBy)));  
				if (stripe < minLength) {
					minLength = stripe;
					dotX = dot;
				}
			}
			List<List<String>> task1ResultList = new ArrayList<>();
			task1ResultList.add(dotX);
			request.setAttribute("task1ResultList", task1ResultList);

			jump("/task1-result.jsp", request, response);
		} catch (IllegalArgumentException | SQLException | ClassNotFoundException ex) {
			jumpError("/task1-preview.jsp", ex.getMessage(), request, response);
		} finally {
            ConnectionControl.close();
        }
	}
}