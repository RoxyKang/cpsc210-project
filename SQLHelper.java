package SQLController;

import JSONController.JSON4SQL;
import Model.UserInfo;
import Model.WishInfo;
import Model.WishListInfo;

import java.sql.*;
import java.text.MessageFormat;
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

    public static boolean initWishInfo() {
        Boolean rm = false;
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = JSON4SQL.getSQL("SQL_WishInfo", "SQL_CreateTable_WishInfo");
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
            sql = String.format(sql, userinfo.getName(), userinfo.getPassWd());
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

    public static boolean insertWishInfo(WishInfo wishInfo) {
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
            MessageFormat.format(sql, wishInfo.getId(), wishInfo.getWishName(), wishInfo.getPrice(), wishInfo.getPeriod(),
                    wishInfo.getResultRounded(), wishInfo.getResultLeft(), wishInfo.getStartingYear(), wishInfo.getStartingMonth(),
                    wishInfo.getEndYear(), wishInfo.getEndMonth());
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
                    user.setUserId(rs.getInt("ID"));
                    user.setName(rs.getString("NAME"));
                    user.setPassWd(rs.getString("PASSWORD"));
                    System.out.println("ID = " + user.getUserId());
                    System.out.println("NAME = " + user.getName());
                    System.out.println("PASSWORD = " + user.getPassWd());

                    System.out.println();
                    userList.put(user.getName(), user);

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
                    user.setUserId(rs.getInt("ID"));
                    user.setName(rs.getString("NAME"));
                    user.setPassWd(rs.getString("PASSWORD"));
                    System.out.println("ID = " + user.getUserId());
                    System.out.println("NAME = " + user.getName());
                    System.out.println("PASSWORD = " + user.getPassWd());

                    System.out.println();

                    user.setWishInfoList(getWishListByUserId(id));

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

    public static Map<String, WishInfo> getWishListByUserId(int userid) {
        Map<String, WishInfo> wishList = new HashMap<String, WishInfo>();

        Statement stmt = null;
        SQLiteJDBC sqlLite = new SQLiteJDBC();

        String sql = JSON4SQL.getSQL("SQL_WishInfo", "SQL_Select_WishInfo");
        sql.replace("@USERID", Integer.toString(userid));

        sqlLite.createSQLConnect();
        try {
            stmt = sqlLite.getConnection().createStatement();
            if (stmt != null) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    WishInfo wish = new WishInfo();

                    wish.setId((rs.getInt("ID")));
                    wish.setUserId(rs.getInt("USERID"));
                    wish.setWishName(rs.getString("WISHNAME"));
                    wish.setPrice(rs.getInt("PRICE"));
                    wish.setPeriod(rs.getInt("PERIOD"));
                    wish.setResultRounded(rs.getDouble("RESULTROUNDED"));
                    wish.setResultLeft(rs.getDouble("RESULTLEFT"));
                    wish.setStartingYear(rs.getInt("STARTINGYEAR"));
                    wish.setStartingMonth(rs.getInt("STARTINGMONTH"));
                    wish.setEndYear(rs.getInt("ENDYEAR"));
                    wish.setEndMonth(rs.getInt("ENDMONTH"));

                    System.out.println();

                    wishList.put(Integer.toString(wish.getId()), wish);

                }
                rs.close();
                stmt.close();
                sqlLite.getConnection().close();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return wishList;
    }

    public static boolean insertWishListById(int listId, WishInfo wishInfo) {
        return true;
    }

    public static WishListInfo getWishList(int listId) {
        return new WishListInfo();
    }

    public static boolean insertWishList(WishListInfo wishListInfo) {
        return true;
    }

    public static HashMap<String, WishInfo> getAllWishInfo() {
        return new HashMap<String, WishInfo>();
    }

    public static boolean checkWishInfoName(WishInfo wishInfo) {
        boolean b = true;
        Statement stmt = null;
        SQLiteJDBC sqlLite = new SQLiteJDBC();

        String sql = JSON4SQL.getSQL("SQL_WishInfo", "SQL_Select_WishInfoByName");
        sql = String.format(sql, wishInfo.getWishName());

        sqlLite.createSQLConnect();
        try {
            stmt = sqlLite.getConnection().createStatement();
            if (stmt != null) {
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next())
                    b = false;
                rs.close();
                stmt.close();
                sqlLite.getConnection().close();
            }

        } catch (Exception e) {
            b = false;
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return b;
    }

}

