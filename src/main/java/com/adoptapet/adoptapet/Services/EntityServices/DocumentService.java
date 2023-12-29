package com.adoptapet.adoptapet.Services.EntityServices;

import com.adoptapet.adoptapet.Dtos.DocumentDto;
import com.adoptapet.adoptapet.Dtos.PetDto;
import com.adoptapet.adoptapet.Entities.Document.Document;
import com.adoptapet.adoptapet.Entities.Document.DocumentId;
import com.adoptapet.adoptapet.Exceptions.DocumentExceptions.DocumentAlreadyExistsException;
import com.adoptapet.adoptapet.Exceptions.DocumentExceptions.DocumentNotFoundException;
import com.adoptapet.adoptapet.Mappers.DocumentMapper;
import com.adoptapet.adoptapet.Mappers.PetMapper;
import com.adoptapet.adoptapet.Repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final PetService petService;
    private final PetMapper petMapper;

    public DocumentService(DocumentRepository documentRepository, DocumentMapper documentMapper, PetService petService, PetMapper petMapper) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
        this.petService = petService;
        this.petMapper = petMapper;
    }

    public List<DocumentDto> getAllDocuments(int petId) {
        List<Document> documents = documentRepository.findAllByPetId(petId);
        return documentMapper.toDtoList(documents);
    }

    public DocumentDto getDocument(int petId, int documentId) {
        PetDto pet = petService.getPet(petId);
        DocumentId petDocumentId = new DocumentId(petMapper.toEntity(pet), documentId);
        if (documentRepository.findById(petDocumentId).isEmpty())
            throw new DocumentNotFoundException();
        Document document = documentRepository.findById(petDocumentId).get();
        return documentMapper.toDto(document);
    }

    public void addDocument(DocumentDto documentDto) {
        DocumentId documentId = new DocumentId(petMapper.toEntity(documentDto.getPet()), documentDto.getDocumentId());
        if (documentRepository.findById(documentId).isPresent())
            throw new DocumentAlreadyExistsException();
        Document document = documentMapper.toEntity(documentDto);
        documentRepository.save(document);
    }

    public void deleteDocument(int petId, int documentId) {
        PetDto pet = petService.getPet(petId);
        DocumentId petDocumentId = new DocumentId(petMapper.toEntity(pet), documentId);
        if (documentRepository.findById(petDocumentId).isEmpty())
            throw new DocumentNotFoundException();
        documentRepository.deleteById(petDocumentId);
    }
}
