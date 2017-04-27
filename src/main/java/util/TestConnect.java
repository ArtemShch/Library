package util;

import db.Database;
import eu.medsea.mimeutil.MimeUtil;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.Collection;
import java.util.Iterator;

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
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = Database.getConnection();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM library.book ");
            while (rs.next()) {
                System.out.println("rs.getString(\"name\") = " + rs.getString("name"));
                byte[] bytes = rs.getBytes("content");
                BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(bytes));
                MimeUtil mimeUtilObject = new MimeUtil();

                Collection<eu.medsea.mimeutil.MimeType> coll = mimeUtilObject.getMimeTypes(bis);

                Iterator<eu.medsea.mimeutil.MimeType> itr = coll.iterator();
                while (itr.hasNext()) {
                    eu.medsea.mimeutil.MimeType mt = itr.next();
                    System.out.println("mt.getMediaType()) = " + mt.getMediaType());
                    System.out.println("mt.getSubType() = " + mt.getSubType());
                    System.out.println("mt.getSpecificity() = " + mt.getSpecificity());

                }
                System.out.println();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
