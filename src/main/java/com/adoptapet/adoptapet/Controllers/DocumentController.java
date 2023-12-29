package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.DocumentDto;
import com.adoptapet.adoptapet.Services.EntityServices.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;
    
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
    
    @GetMapping("/{petId}")
    public ResponseEntity<List<DocumentDto>> getAllDocuments(@PathVariable int petId) {
        return ResponseEntity.ok(documentService.getAllDocuments(petId));
    }
    
    @GetMapping("/{petId}/{documentId}")
    public ResponseEntity<DocumentDto> getDocument(@PathVariable int petId, @PathVariable int documentId) {
        return ResponseEntity.ok(documentService.getDocument(petId, documentId));
    }
    
    @PostMapping
    public ResponseEntity<String> addDocument(@RequestBody DocumentDto documentDto) {
        documentService.addDocument(documentDto);
        return ResponseEntity.ok("Document added successfully");
    }
    
    @DeleteMapping("/{petId}/{documentId}")
    public ResponseEntity<String> deleteDocument(@PathVariable int petId, @PathVariable int documentId) {
        documentService.deleteDocument(petId, documentId);
        return ResponseEntity.ok("Document deleted successfully");
    }
}
