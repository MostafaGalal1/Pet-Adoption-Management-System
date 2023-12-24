package com.adoptapet.adoptapet.Entities.Document;

import com.adoptapet.adoptapet.Entities.Pet.Pet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@IdClass(DocumentId.class)
@Table(name = "Document")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {
    @Id
    @Column(name = "petId")
    private int petId;

    @Id
    @Column(name = "documentId")
    private int documentId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "petId")
    private Pet pet;
}