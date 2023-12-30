package com.adoptapet.adoptapet.Services.SearchService;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import com.adoptapet.adoptapet.Services.EntityServices.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchService {
    private final PetService petService;

    @Autowired
    public SearchService(PetService petService) {
         this.petService = petService;
     }

    public Page<Pet> searchPets(Map<String, String> searchParams, int pageCount) {
        return petService.findAllPets(createSearchSpecification(searchParams), pageCount);
    }

    private <T> Specification<T> createSearchSpecification(Map<String, String> searchParams) {
        SearchSpecification<T> searchSpecification = new SearchSpecification<>();
        List<Specification<T>> specifications = new ArrayList<>();
        for (Map.Entry<String, String> entry : searchParams.entrySet()) {
            if (entry.getKey().equals("pageCount")) continue;
            SearchFilter searchFilter = SearchFilter.builder().field(entry.getKey()).operator(SearchFilter.QueryOperator.LIKE).value(entry.getValue()).build();
            specifications.add(searchSpecification.createSpecification(searchFilter));
        }
        return searchSpecification.intersection(specifications);
    }
}