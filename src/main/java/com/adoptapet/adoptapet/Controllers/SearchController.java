package com.adoptapet.adoptapet.Controllers;

import org.springframework.data.domain.Page;
import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Services.BusinessSerivces.SearchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/pets")
    public Page<Pet> searchClinics(@RequestParam Map<String, String> searchParams, @RequestParam int pageCount) {
        return searchService.searchPets(searchParams, pageCount);
    }
}