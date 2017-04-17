package beans;

import java.util.Date;

/**
 * Created by artem on 17.04.17.
 */
public class Book {
    public Book() {
    }

    public Book(String name, int pageCount, int genreId, int authorId, Date publishYear, int publisherId, String isbn) {
        this.name = name;
        this.pageCount = pageCount;
        this.genreId = genreId;
        this.authorId = authorId;
        this.publishYear = publishYear;
        this.publisherId = publisherId;
        this.isbn = isbn;
    }

    private String name;

    private int pageCount;

    private int genreId;

    private int authorId;

    private Date publishYear;

    private int publisherId;

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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
