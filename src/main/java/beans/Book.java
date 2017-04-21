package beans;

import java.awt.*;
import java.util.Date;

public class Book {
    public Book() {
    }

    public Book(String name, int pageCount, int genreId, String author, Date publishYear, byte[] image, String publisher, String isbn) {
        this.name = name;
        this.pageCount = pageCount;
        this.genreId = genreId;
        this.author = author;
        this.publishYear = publishYear;
        this.image = image;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    private String name;

    private int pageCount;

    private int genreId;

    private String author;

    private Date publishYear;

    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    private String publisher;

    private String isbn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }
}
