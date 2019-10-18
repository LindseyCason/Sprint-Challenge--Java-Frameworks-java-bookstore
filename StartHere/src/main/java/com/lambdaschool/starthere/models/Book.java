package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value= "Book", description = "The Book Model")
//this will show in swagger
@Entity
@Table(name= "book")
public class Book extends Auditable
{

@ApiModelProperty(name = "bookid", value = "Primary Key for Each Book", required = true, example = "143")
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long bookid;

@ApiModelProperty(name= "title", value = "Title of the book", required = true, example = "Wizard of Oz")
@Column(nullable = false)
private String title;

@ApiModelProperty(name= "isbn", value = "The ISBN of each book", required = true, example = "8675309")
@Column(nullable = false, unique = true)
private String ISBN;

@ApiModelProperty(name= "copy", value = "Copyright Date", example = "2019")
@Column(nullable = false, unique = false)
private int copy;

//public long sectionid;


//    //The is a one to many relationship between sections and books. One section can hold many books while a book can only be in one sction
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "sectionid", nullable = false)
@JsonIgnoreProperties(value = {"books", "hibernateLazyInitializer"}) //?? //thsi was in restaurant/menu project
private Section section;




    @ManyToMany
@JoinTable(name = "authorsBooks", joinColumns = {@JoinColumn(name="bookid")}, inverseJoinColumns = {@JoinColumn(name="authorid")})
    private List<Author> authors = new ArrayList<>( );

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

//    public long getSectionid() {
//        return sectionid;
//    }
//
//    public void setSectionid(long sectionid) {
//        this.sectionid = sectionid;
//    }

    public Book() {
        //default constructor needed
    }


    public Book(String title, String ISBN, int copy,long sectionid) {
        this.title = title;
        this.ISBN = ISBN;
        this.copy = copy;
//        this.sectionid = sectionid;
    }

    //generate getters and setters


    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }
}
