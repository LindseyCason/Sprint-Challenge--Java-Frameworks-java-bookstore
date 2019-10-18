package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepo extends PagingAndSortingRepository<Book, Long>
{

}