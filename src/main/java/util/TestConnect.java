package util;

import java.sql.*;

public class TestConnect {
    public void check(){
        try {
            String url = "jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
            while (resultSet.next())
            System.out.println(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestConnect testConnect = new TestConnect();
        testConnect.check();
    }
}
