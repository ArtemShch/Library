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

        try {
            Connection connection = Database.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM library.author ORDER BY fio");

            while (resultSet.next())
            {
                Author author = new Author();

                author.setName(resultSet.getString("fio"));
                authors.add(author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return authors;
    }
}
