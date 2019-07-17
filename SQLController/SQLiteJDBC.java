package SQLController;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteJDBC {
    private Connection c;

    public void createSQLConnect() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public Connection getConnection() {
        return this.c;
    }

}