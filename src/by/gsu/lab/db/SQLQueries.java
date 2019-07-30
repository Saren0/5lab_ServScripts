package by.gsu.lab.db;

/**
 * SQL-запросы
 * @author Palachanin Aliaksei
 */
public class SQLQueries {

    final static String PS_INSERT_COORDINATES =
            "INSERT INTO dots.coordinates (x, y) VALUES (?, ?);";

    final static String PS_SELECT_COORDINATES =
            "SELECT * FROM dots.coordinates;";

    public final static String PS_SELECT_COORDINATES_WITH_PARAMETERS =
            "SELECT * FROM dots.coordinates WHERE x = ? AND y = ?;";
}