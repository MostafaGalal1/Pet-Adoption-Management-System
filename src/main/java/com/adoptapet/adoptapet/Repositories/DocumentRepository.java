package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Document.Document;
import com.adoptapet.adoptapet.Entities.Document.DocumentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, DocumentId> {
}