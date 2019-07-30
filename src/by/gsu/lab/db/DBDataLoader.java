package by.gsu.lab.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс с методами выполнения запросов, согласно заданиям.
 * @author Palachanin Aliaksei
 */
public class DBDataLoader {

    public List<List<String>> getAllDots(Connection connection) throws SQLException {
        final int INDEX_ID = 1;
        final int INDEX_X_DOTS = 2;
        final int INDEX_Y_DOTS = 3;
        List<List<String>> result = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(
                    SQLQueries.PS_SELECT_COORDINATES);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<String> currentList = new ArrayList<>();
                currentList.add(Integer.toString(resultSet.getInt(INDEX_ID)));
                currentList.add(Integer.toString(resultSet.getInt(INDEX_X_DOTS)));
                currentList.add(Integer.toString(resultSet.getInt(INDEX_Y_DOTS)));
                result.add(currentList);
            }
            return result;
        } finally {
            ConnectionControl.close(resultSet);
            ConnectionControl.close(preparedStatement);
        }
    }
}