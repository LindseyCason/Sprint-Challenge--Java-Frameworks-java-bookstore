package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService
{
    List<Book> findAll(Pageable pageable);
    //GET /books/books

    Book update( Book book, long id);
    //PUT /data/books/{id}

    void delete(long id);
    ///DELETE /data/books/{id}


    void assignBookToAuthor(long bookid, long authorid);
    ///POST /data/books/{bookid}/authors/{authorid}

    void save(Book book);
}