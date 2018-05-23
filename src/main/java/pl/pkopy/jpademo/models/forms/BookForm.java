package pl.pkopy.jpademo.models.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BookForm {
    @NotEmpty
    @Size(max = 50)
    private String title;
    @NotEmpty
    @Size(max = 50)
    private String author;
    @NotEmpty
    private int pages;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
