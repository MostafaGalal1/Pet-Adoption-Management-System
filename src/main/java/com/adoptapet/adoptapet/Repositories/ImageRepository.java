package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Image.Image;
import com.adoptapet.adoptapet.Entities.Image.ImageId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, ImageId> {
}