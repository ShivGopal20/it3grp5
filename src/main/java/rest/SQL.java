package rest;

import java.sql.*;
import java.time.Instant;

public class SQL {

    String Brugernavn;
    String Adgangskode;
    String CPR;
    String dato;
    String startTidspunkt;
    String slutTidspunkt;
    String sundhedsPersonale;
    String aftalePerson;
    String  notat;



    static private final SQL sqlOBJ = new SQL();

    static public SQL getSqlOBJ() {
        return sqlOBJ;
    }


    private static Connection connection;
    static Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    // indstillinger, valg af database
    static String username = "s194054";
    static String password = "EkqheiOgMCjZd9VWrMtts";
    static String Schema = "s194054";
    static String url = "jdbc:mysql://mysql-db.caprover.diplomportal.dk/" + Schema;


    public void getSQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            if (connection != null) {
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }




    // metode til at skrive data i databsen
    public void insertIntoTable(String CPR, double EKGdata) {
        Timestamp tid = Timestamp.from(Instant.now());

        //læg data i skema
        String SQL = "insert into maalinger (CPR,EKGMeasure,Time) values(?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, CPR);
            preparedStatement.setDouble(2, EKGdata);
            preparedStatement.setTimestamp(3, tid);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }





    // metode til at hente Logindata fra tabel
    public String getLoginInfo(int ID) {
        getSQLConnection();
        String query1 = "SELECT * FROM s194054.brugerliste where ID=" + ID + ";";
        try {
            resultSet = statement.executeQuery(query1);
            resultSet.next();
            if (resultSet != null) {
                Brugernavn = resultSet.getString("fullname");
                Adgangskode = resultSet.getString("password");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Brugernavn;
    }
/*
    public String retrieveAftale(int ID) {
        getSQLConnection();
        String query1 = "SELECT * FROM laegedatabasen.patient where ID=" + ID + ";";
        try {
            resultSet = statement.executeQuery(query1);
            resultSet.next();
            System.out.println(
            CPR = resultSet.getString("CPR"));
            dato = resultSet.getString("dato");
            startTidspunkt = resultSet.getString("starttid");
            slutTidspunkt = resultSet.getString("sluttid");
            sundhedsPersonale = resultSet.getString("sundhedspersonale");
            aftalePerson = resultSet.getString("aftaleperson");
            notat= resultSet.getString("notater");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        return query1;
    }

 */



    public String opretNyPatient(String CPR, String dato, String startTidspunkt, String slutTidspunkt, String sundhedsPersonale, String aftalePerson, String notater) {
        getSQLConnection();
        String write_to_database1 = "INSERT INTO s194054.Patient (CPR, dato,starttid,sluttid,sundhedspersonale,aftaleperson,notater) values(?,?,?,?,?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(write_to_database1);
            preparedStatement.setString(1, CPR);
            preparedStatement.setString(2, dato);
            preparedStatement.setString(3, startTidspunkt);
            preparedStatement.setString(4, slutTidspunkt);
            preparedStatement.setString(5, sundhedsPersonale);
            preparedStatement.setString(6, aftalePerson);
            preparedStatement.setString(7, notater);
            preparedStatement.execute();
        } catch (SQLException throwables) {
        //    System.out.println("CPR eksisterer allerede i systemet.");
        }


        return write_to_database1;
    }



    }




