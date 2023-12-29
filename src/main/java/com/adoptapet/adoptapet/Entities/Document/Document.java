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
    @Column(name = "documentId")
    private int documentId;

    @Column(name = "type")
    private String type;

    @Column(name = "link")
    private String link;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "petId")
    private Pet pet;
}