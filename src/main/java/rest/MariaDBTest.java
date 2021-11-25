package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBTest {
    public MariaDBTest() {}


    public static Connection getConnection() {
        Connection connection = null;
        try {
            try {
                if (connection == null || connection.isClosed()) {
                    try {
                       // Class.forName("com.mysql.cj.jdbc.Driver");
                       //Class.forName("org.mariadb.jdbc.Driver");

                        String user, pass, url;
                        user = "bruger1";
                        pass = "kode1";
                        url = "jdbc:mariadb://192.168.1.177:3306/laegedatabasen?serverTimezone=Europe/Amsterdam&amp";

                       connection = DriverManager.getConnection(url, user, pass);
                    } catch (
                            SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        getConnection(); }
}



