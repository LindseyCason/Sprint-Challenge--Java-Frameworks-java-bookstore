package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Section;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SectionService {

    List<Section> findAll(Pageable pageable);
    //returning all

    void delete(long id);
    ///DELETE


    void save(Section section);

}
