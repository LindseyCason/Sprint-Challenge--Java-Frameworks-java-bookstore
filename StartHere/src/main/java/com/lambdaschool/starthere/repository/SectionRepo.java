package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Section;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SectionRepo extends PagingAndSortingRepository<Section, Long>
{

}