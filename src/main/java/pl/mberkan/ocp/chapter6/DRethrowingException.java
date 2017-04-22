package pl.mberkan.ocp.chapter6;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

/**
 * @author Marek Berkan
 */
public class DRethrowingException {

    public static void main(String[] args) throws Exception {
        expliciteCatch();
        possibleCatch();
    }

    private static void expliciteCatch() throws SQLException, DateTimeParseException {
        try {
            parseDate();
        } catch (SQLException | DateTimeParseException e) { // we need duplicate method signatures
            System.err.println("Catch: " + e.getMessage());
            throw e;
        }
    }

    private static void possibleCatch() throws SQLException, DateTimeParseException {
        try {
            parseDate();
        } catch (Exception e) { // Java assume that methods declaration list is the same :-)
            System.err.println("Catch: " + e.getMessage());
            throw e;
        }
    }

    // adding new throws compilation error in both invocations!
    private static void parseDate() throws SQLException, DateTimeParseException { //, IOException {
        throw new SQLException("Test");
    }
}
