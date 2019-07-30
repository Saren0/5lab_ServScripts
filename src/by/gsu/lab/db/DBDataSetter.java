package by.gsu.lab.db;

import java.sql.*;

/**
 * 
 * @author Palachanin Aliaksei
 */
public class DBDataSetter {

	public void insertDots(Connection connection, int x, int y)
		throws SQLException {
		
		final int INDEX_X = 1;
		final int INDEX_Y = 2;
        PreparedStatement psInsertDots = null;
        try {
            psInsertDots = connection.prepareStatement(
                    SQLQueries.PS_INSERT_COORDINATES);
            psInsertDots.setInt(INDEX_X, x);
            psInsertDots.setInt(INDEX_Y, y);
            psInsertDots.executeUpdate();
        } finally {
            ConnectionControl.close(psInsertDots);
        }
	}
}
