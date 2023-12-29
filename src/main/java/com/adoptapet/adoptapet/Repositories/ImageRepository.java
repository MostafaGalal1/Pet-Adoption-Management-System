package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Image.Image;
import com.adoptapet.adoptapet.Entities.Image.ImageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, ImageId> {
    List<Image> findAllByPetId(int petId);
}