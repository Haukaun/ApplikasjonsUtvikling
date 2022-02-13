package no.ntnu.crudrest.Random;

import io.swagger.annotations.ApiModelProperty;

public class Book {
    @ApiModelProperty("Unique id of the book")
    private int id;
    @ApiModelProperty("Name of the title")
    private String title;
    @ApiModelProperty("Release year of the book")
    private int year;
    @ApiModelProperty("Number of pages")
    private int numberOfPages;

    public Book(int id, String title, int year, int numberOfPages) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.numberOfPages = numberOfPages;
    }

    /**
     * Check if this object is a valid book
     * @return
     */
    public boolean isValid(){
        return id > 0 && title != null && !title.equals("") ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the year of publication for the book
     * @return
     */
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
