package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements  AuthorService
{
    @Autowired
    private AuthorRepo authorrepo;

    @Override
    public List<Author> findAll(Pageable pageable)
    {
        List<Author> authorList = new ArrayList<>();
        //making a new list of Author called authorList whichis a new array list
        authorrepo.findAll(pageable).iterator().forEachRemaining(authorList::add);
        //finding all pageable authors and iterating through each one until no more are remaining to add to the list
        return authorList;
        //returning the authorList array
    }


    @Override
    public void save(Author author)
    {
        authorrepo.save(author);
    }
}