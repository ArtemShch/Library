package beans;

import db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GenreList {

    private ArrayList<Genre> genres = null;

    public ArrayList<Genre> getGenres() {
        genres = new ArrayList<Genre>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library.genre ORDER BY name");

            while (resultSet.next()) {
                Genre genre = new Genre();

                genre.setName(resultSet.getString("name"));
                genre.setId(resultSet.getLong("id"));
                genres.add(genre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return genres;
    }
}
