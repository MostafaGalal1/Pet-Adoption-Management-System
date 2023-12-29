package com.adoptapet.adoptapet.Entities.Pet;

import com.adoptapet.adoptapet.Entities.Document.Document;
import com.adoptapet.adoptapet.Entities.Gender;
import com.adoptapet.adoptapet.Entities.Image.Image;
import com.adoptapet.adoptapet.Entities.Shelter;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pet")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "healthStatus")
    @Enumerated(EnumType.STRING)
    private HealthStatus healthStatus;

    @Column(name = "behaviour")
    @Enumerated(EnumType.STRING)
    private Behaviour behaviour;

    @Column(name = "description")
    private String description;

    @Column(name = "adopted")
    private boolean adopted;

    @Column(name = "vaccinated")
    private boolean vaccinated;

    @Column(name = "castrated")
    private boolean castrated;

    @Column(name = "houseTrained")
    private boolean houseTrained;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "shelterId")
    private Shelter shelter;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "petId")
    @ToString.Exclude
    private List<Document> documents;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "petId")
    @ToString.Exclude
    private List<Image> images;

    void addDocument(Document document) {
        if (documents == null)
            documents = new ArrayList<>();
        documents.add(document);
        document.setPet(this);
    }

    void addImage(Image image) {
        if (images == null)
            images = new ArrayList<>();
        images.add(image);
        image.setPet(this);
    }

    void removeDocument(Document document) {
        if (documents != null) {
            documents.remove(document);
            document.setPet(null);
        }
    }

    void removeImage(Image image) {
        if (images != null) {
            images.remove(image);
            image.setPet(null);
        }
    }
}