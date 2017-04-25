package beans;

import db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AuthorList {
    private ArrayList<Author> authors = new ArrayList<Author>();

    public ArrayList<Author> getAuthors() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library.author ORDER BY fio");

            while (resultSet.next())
            {
                Author author = new Author();
                author.setId(resultSet.getLong("id"));
                author.setName(resultSet.getString("fio"));
                authors.add(author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return authors;
    }
}
