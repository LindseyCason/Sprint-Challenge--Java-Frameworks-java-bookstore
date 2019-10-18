package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.AuthorRepo;
import com.lambdaschool.starthere.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepo bookrepo;

    @Autowired
    private AuthorRepo authorrepo;

    @Override
    public List<Book> findAll(Pageable pageable)
    {
        List<Book> bookList = new ArrayList<>();
        //make a new Book list called bookLlist which is a new array list
        bookrepo.findAll(pageable).iterator().forEachRemaining(bookList::add);
        //find all the books and add them to the list until there are noneremaining
        return bookList;
    }

    @Transactional
    @Override
    public Book update(Book book,
                             long id)
    {
        Book currentBook = bookrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (book.getTitle() != null)
        {
            currentBook.setTitle(book.getTitle());
        }
        if (book.getCopy() >0) {
            currentBook.setCopy( book.getCopy() );
        }
        if (book.getISBN() != null){
            currentBook.setISBN( book.getISBN() );
        }

        return bookrepo.save(currentBook);
    }

    @Override
    public void delete(long id)
    {
        if(bookrepo.findById(id).isPresent())
        {
            bookrepo.deleteById(id);
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    @Override
    public void assignBookToAuthor(long bookid, long authorid)
    {
        Book selectedBook = bookrepo.findById(bookid).orElseThrow(EntityNotFoundException::new);
        selectedBook.getAuthors().add(authorrepo.findById(authorid).orElseThrow(EntityNotFoundException::new));
        //this is adding to the array list listed inside of books..... calling getAuthors returning authors
    }

    @Override
    public void save(Book book)
    {
        bookrepo.save(book);
    }
}