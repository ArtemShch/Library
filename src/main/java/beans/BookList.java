package beans;

import db.Database;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;


public class BookList {
    private ArrayList<Book> booksByGenre = null;

    public ArrayList<Book> getBooksByGenre(long genreId) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        booksByGenre = new ArrayList();
        try {
            connection = Database.getConnection();

            statement = connection.createStatement();
            resultSet =
                    statement.executeQuery("SELECT" +
                            "    book.name as bookName," +
                            "    book.content," +
                            "    book.page_count," +
                            "    book.isbn," +
                            "    genre.name AS genreName," +
                            "    author.fio," +
                            "    book.publish_year," +
                            "    publisher.name AS publisherName," +
                            "    book.image" +
                            " FROM library.book" +
                            " JOIN library.genre" +
                            " ON genre.id = " + genreId  +
                            " JOIN library.author " +
                            "ON author.id = book.author_id" +
                            " JOIN library.publisher" +
                            " ON publisher.id = book.publisher_id" +
                            " WHERE book.genre_id = " + genreId +";");

            while (resultSet.next())
            {
                Book book = new Book();

                book.setName(resultSet.getString("bookName"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setPublisher(resultSet.getString("publisherName" ));
                book.setPageCount(resultSet.getInt("page_count"));
                book.setAuthor(resultSet.getString("fio"));
                book.setPublishYear(resultSet.getDate("publish_year"));

                //get image
                Blob blob = resultSet.getBlob("image");
                byte[] imageInByteArray = blob.getBytes(1, (int) blob.length());
                book.setImage(imageInByteArray);

                booksByGenre.add(book);
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

        return booksByGenre;

    }
}
