package org.example;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
import java.util.Set;

public class Main {


    private static final String connectionUrl = "jdbc:mysql://localhost:3306/sys";

    private static final String USER_SELECT_STRING = "select * from ofis";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {


         //**************************INSERT*****************************************************
        try(Connection conn = DriverManager.getConnection(connectionUrl,"root","6424235");
            Statement statement = conn.createStatement();
        ) { String sql = "INSERT INTO VALUES (5, 'samet', 25, true)";
            statement.executeUpdate(sql);
        }
        catch (SQLException sqlException) {
            System.out.println(" SQL HATASI");
        }

        //****************************UPDATE****************************************************

        try(Connection conn = DriverManager.getConnection(connectionUrl,"root","6424235");
            Statement statement = conn.createStatement();
        ) { String sql = "Update ofis Set age=26 Where id=5";
            statement.executeUpdate(sql);
        }
        catch (SQLException sqlException) {
            System.out.println(" SQL HATASI");
        }
        //****************************DELETE**************************************

        try(Connection conn = DriverManager.getConnection(connectionUrl,"root","6424235");
            Statement statement = conn.createStatement();
        ) { String sql = "DELETE From ofis where id=2";
            statement.executeUpdate(sql);
        }
        catch (SQLException sqlException) {
            System.out.println(" SQL HATASI");
        }



        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "6424235")) {

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(USER_SELECT_STRING);



            while (result.next()) {

                System.out.print(result.getString(1) + "  ");
                System.out.print(result.getString(2) + "  ");
                System.out.println(result.getString(3));
            }

        } catch (SQLException sqlException) {
            System.out.println(" SQL HATASI");
        }


    }
}