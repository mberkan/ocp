package pl.mberkan.ocp.chapter10;

import java.sql.*;

import static pl.mberkan.ocp.Utils.printSeparator;

/**
 * Postgres database creation:
 * $ sudo su - postgres
 * $ psql
 * $ create database ocp;
 * $ create user ocp with password 'ocp';
 * $ \q
 * $ psql -u ocp ocp
 * $ CREATE TABLE species (id INTEGER PRIMARY KEY, name VARCHAR(255), num_acres DECIMAL);
 * $ CREATE TABLE animal (id INTEGER PRIMARY KEY, species_is INTEGER, name VARCHAR(255), date_born TIMESTAMP);
 * $ INSERT INTO species VALUES (1, 'African Elephant', 7.5);
 * $ INSERT INTO species VALUES (2, 'Zebra', 1.2);
 * $ INSERT INTO animal VALUES (1, 1, 'Elsa', '2001-05-06 02:15');
 * $ INSERT INTO animal VALUES (2, 2, 'Zelda', '2002-08-15 09:12');
 * $ INSERT INTO animal VALUES (3, 1, 'Ester', '2002-09-09 10:36');
 * $ INSERT INTO animal VALUES (4, 1, 'Eddie', '2010-06-08 01:24');
 * $ INSERT INTO animal VALUES (5, 2, 'Zoe', '2005-11-12 03:44');
 */
public class AStatements {

    public static final String URL = "jdbc:postgresql://localhost:5432/ocp";
    public static final String USER = "ocp";
    public static final String PASSWORD = "ocp";

    public static void main(String[] args) throws SQLException {
        executeSimpleQuery();
        printSeparator();

        executeUnexpectedQueryType();
        printSeparator();

        executeQueryForTimeAndDate();
        printSeparator();

        moveCursorUpAndDown();
        printSeparator();

        moveCursorAbsoluteAndRelative();
        printSeparator();
    }

    private static void executeSimpleQuery() throws SQLException {
        // Class.forName("org.postgresql.Driver"); -> no longer needed
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_FORWARD_ONLY, // other: TYPE_SCROLL_INSENSITIVE, TYPE_SCROLL_INSENSITIVE (allow scrolling on data snapshot or live data reload)
                     ResultSet.CONCUR_READ_ONLY); // other: CONCUR_UPDATABLE (allow changes)
             ResultSet rs = stmt.executeQuery("SELECT name FROM animal")) {
            while (rs.next()) {
                System.out.println(rs.getString(1)); // first index is "1" (!)
            }
        }
    }

    private static void executeUnexpectedQueryType() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            boolean isResultSet = stmt.execute("DELETE FROM animal WHERE id = 10000");
            if (isResultSet) {
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            } else {
                int result = stmt.getUpdateCount();
                System.out.println("Updated " + result + " rows");
            }
        }
    }

    private static void executeQueryForTimeAndDate() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT date_born FROM animal WHERE name = 'Elsa'")) {
            if (rs.next()) {
                java.sql.Date sqlDate = rs.getDate(1);
                System.out.println("Date: " + sqlDate.toLocalDate());

                java.sql.Time sqlTime = rs.getTime(1);
                System.out.println("Time: " + sqlTime.toLocalTime());

                java.sql.Timestamp sqlTimestamp = rs.getTimestamp(1);
                System.out.println("Timestamp: " + sqlTimestamp.toLocalDateTime());
            } else {
                System.err.println("No rows returned");
            }
        }
    }

    private static void moveCursorUpAndDown() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT id FROM species ORDER BY id")) {
            rs.afterLast();
            System.out.println(rs.previous());
            System.out.println(rs.getInt(1));
            System.out.println(rs.previous());
            System.out.println(rs.getInt(1));
            System.out.println(rs.last());
            System.out.println(rs.getInt(1));
            System.out.println(rs.first());
            System.out.println(rs.getInt(1));
        }
    }

    private static void moveCursorAbsoluteAndRelative() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT id FROM animal ORDER BY id")) {
            rs.absolute(1); // -> first row
            System.out.println(rs.getInt(1)); // return false when is before first or after last

            rs.absolute(-1); // -> last row
            System.out.println(rs.getInt(1));

            rs.relative(-3); // -> 3 rows up
            System.out.println(rs.getInt(1));

        }
    }
}
