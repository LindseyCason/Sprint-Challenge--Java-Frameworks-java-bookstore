package com.lambdaschool.starthere.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Author", description = "The Author Model")
@Entity
@Table(name = "author")
public class Author extends Auditable
{
    @ApiModelProperty(name = "authorid", value = "Primary Key for The Authors", required = true, example = "286")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @ApiModelProperty(name = "fname", value = "First name of the author", required = true, example = "Dorothy")
    @Column
    private String fname;

    @ApiModelProperty(name = "lname", value= "Last Name of the Author", required = true, example = "Gale")
    private String lname;

    @ManyToMany(mappedBy = "authors")
    //There is a many to many relationship between authors and books. A book may have many authors while an author may write many books.
    @JsonIgnoreProperties(value = "authors")
    private List<Book> books = new ArrayList<>(  );

    public Author(){
        //default constructor
    }

    public Author(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.books = books;
    }

    public Author(long authorid, Book currentBook) {
        super();
    }

    //make getters and setters

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

//    public void setBooks(List<Book> books){
//        this.books = books;
//    }
}
