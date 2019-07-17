package SQLController;

import JSONController.JSON4SQL;
import Model.UserInfo;

import java.sql.*;

import java.util.*;

public class SQLHelper {

    public static boolean initUserInfo() {
        boolean rm = false;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = JSON4SQL.getSQL("SQL_UserInfo", "SQL_CreateTable_UserInfo");
            System.out.println(sql);

            rm = stmt.executeUpdate(sql) > 0;
            stmt.close();
            c.close();
        } catch (Exception e) {
            rm = false;
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
        return rm;
    }

    public static boolean insertUserInfo(UserInfo userinfo) {
        Boolean rm = false;
        Connection c = null;
        Statement stmt = null;
        String sql = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            sql = JSON4SQL.getSQL("SQL_UserInfo", "SQL_Insert_UserInfo");
            sql = String.format(sql, userinfo.getUsername(), userinfo.getPassword());
            System.out.println(sql);

            rm = stmt.executeUpdate(sql) > 0;
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            rm = false;
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
        return rm;
    }

    public static Map getUserInfo() {

        Map userList = new HashMap();
        Statement stmt = null;
        SQLiteJDBC sqlLite = new SQLiteJDBC();

        String sql = JSON4SQL.getSQL("SQL_UserInfo", "SQL_Select_UserInfo");
        sqlLite.createSQLConnect();
        try {
            stmt = sqlLite.getConnection().createStatement();
            if (stmt != null) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    UserInfo user = new UserInfo();
                    user.setUserID(rs.getInt("ID"));
                    user.setUsername(rs.getString("NAME"));
                    user.setPassword(rs.getString("PASSWORD"));
                    System.out.println("ID = " + user.getUserID());
                    System.out.println("NAME = " + user.getUsername());
                    System.out.println("PASSWORD = " + user.getPassword());

                    System.out.println();
                    userList.put(user.getUsername(), user);

                }
                rs.close();
                stmt.close();
                sqlLite.getConnection().close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return userList;
    }

    public static UserInfo getUserInfoById(int id) {

        UserInfo userInfo = new UserInfo();
        Statement stmt = null;
        SQLiteJDBC sqlLite = new SQLiteJDBC();

        String sql = JSON4SQL.getSQL("SQL_UserInfo", "SQL_Select_UserInfoById");
        sql.replace("@ID", Integer.toString(id));

        sqlLite.createSQLConnect();
        try {
            stmt = sqlLite.getConnection().createStatement();
            if (stmt != null) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    UserInfo user = new UserInfo();
                    user.setUserID(rs.getInt("ID"));
                    user.setUsername(rs.getString("NAME"));
                    user.setPassword(rs.getString("PASSWORD"));
                    System.out.println("ID = " + user.getUserID());
                    System.out.println("NAME = " + user.getUsername());
                    System.out.println("PASSWORD = " + user.getPassword());

                    System.out.println();

                }
                rs.close();
                stmt.close();
                sqlLite.getConnection().close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return userInfo;
    }

}

