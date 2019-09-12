package SQLController;

import java.sql.Connection;
import java.sql.DriverManager;

class SQLiteJDBC {
    private Connection c;

    void createSQLConnect() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    Connection getConnection() {
        return this.c;
    }

}