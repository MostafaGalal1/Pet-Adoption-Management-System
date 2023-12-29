package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Document.Document;
import com.adoptapet.adoptapet.Entities.Document.DocumentId;
import com.adoptapet.adoptapet.Entities.Image.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, DocumentId> {
    List<Document> findAllByPetId(int petId);
}