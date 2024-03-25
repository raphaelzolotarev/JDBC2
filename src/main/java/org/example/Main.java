package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "2024");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from beers");

            while(resultSet.next()) {
                System.out.println(
                        resultSet.getRow() + "|" +
                        resultSet.getInt("id") + "|" +
                                resultSet.getString("name") + "|" +
                                resultSet.getInt("brewerid") + "|" +
                                resultSet.getInt("categoryid") + "|" +
                                resultSet.getFloat("price") + "|" +
                                resultSet.getInt("stock") + "|" +
                                resultSet.getFloat("alcohol") + "|"

                );
            }

            Statement insertStatement = connection.createStatement();
            //insertStatement.execute("insert into beers (name,brewerid,categoryid,price,stock,alcohol) values ('jupiler',17,33,50,100,7)");

            Statement updateStatement = connection.createStatement();
            //updateStatement.executeUpdate("update beers set name='jupiler goed' where id=1557") ;

            Statement deleteStatement = connection.createStatement();
            updateStatement.execute("delete from beers where name='jupiler goed'") ;


        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

    }
}