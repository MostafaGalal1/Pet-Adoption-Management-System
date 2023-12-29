package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.DocumentDto;
import com.adoptapet.adoptapet.Services.EntityServices.DocumentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;
    
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
    
    @GetMapping("/{petId}")
    public void getAllDocuments(@PathVariable int petId) {
        documentService.getAllDocuments(petId);
    }
    
    @GetMapping("/{petId}/{documentId}")
    public DocumentDto getDocument(@PathVariable int petId, @PathVariable int documentId) {
        return documentService.getDocument(petId, documentId);
    }
    
    @PostMapping
    public void addDocument(@RequestBody DocumentDto documentDto) {
        documentService.addDocument(documentDto);
    }
    
    @DeleteMapping("/{petId}/{documentId}")
    public void deleteDocument(@PathVariable int petId, @PathVariable int documentId) {
        documentService.deleteDocument(petId, documentId);
    }
}
