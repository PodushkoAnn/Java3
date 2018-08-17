package lesson2.homework;

import java.sql.*;

public class MyDatabase {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;


    public MyDatabase() {
        try {
            connect();
            stmt = connection.createStatement();

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS  'main'.'products' (\n" +
                    "'id' INTEGER NOT NULL, \n" +
                    "'prodid'INT UNIQUE,\n" +
                    "'title' VARCHAR(128),\n" +
                    "'cost' DECIMAL(10, 2),\n" +
                    "PRIMARY KEY (id AUTOINCREMENT));");
            stmt.executeUpdate("DELETE from main.'products';");

            pstmt = connection.prepareStatement("INSERT INTO main.'products' (prodid, title, cost)\n" +
            "VALUES (?, ?, ?)");

            connection.setAutoCommit(false);
            for (int i = 1; i <= 10000; i++) {
                pstmt.setInt(1, i);
                pstmt.setString(2, "товар" + i);
                pstmt.setInt(3, i*10);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void makeQuery(String statement, int i){
        try {
            connect();
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(statement);
                if(!rs.next()) System.out.println("Такого товара нет");
                else System.out.println(rs.getString(i));
                    while (rs.next()) {
                    System.out.println(rs.getString(i));
                    }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void makeUpdate(String statement){
        try {
            connect();
            stmt = connection.createStatement();
            stmt.executeUpdate(statement);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }
}
