package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Section;
import com.lambdaschool.starthere.services.SectionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.data.domain.Pageable;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @ApiOperation(value = "Returns all sections", response = Section.class, responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", dataType = "integr", paramType = "query", value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of Items per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting: " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})

    @GetMapping(value = "/sections")
    public ResponseEntity<?> findAllSections(Pageable pageable){
        List<Section> sectionList = sectionService.findAll(pageable);
        return new ResponseEntity<>(sectionList, HttpStatus.OK );
    }
}
