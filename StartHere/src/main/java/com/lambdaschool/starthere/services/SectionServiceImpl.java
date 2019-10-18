package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Section;
import com.lambdaschool.starthere.repository.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService
{

    @Autowired
    private SectionRepo sectionrepo;

    @Override
    public List<Section> findAll(Pageable pageable) {

        List<Section> sectionList = new ArrayList<>();
        //making a new list of Sections called sectionList whichis a new array list
        sectionrepo.findAll(pageable).iterator().forEachRemaining(sectionList::add);
        //finding all pageable sections and iterating through each one until no more are remaining to add to the list
        return sectionList;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void save(Section section) {

    }
}
