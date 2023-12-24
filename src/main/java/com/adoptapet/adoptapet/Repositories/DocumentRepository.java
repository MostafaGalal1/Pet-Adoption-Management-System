package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Document.Document;
import com.adoptapet.adoptapet.Entities.Document.DocumentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, DocumentId> {
}