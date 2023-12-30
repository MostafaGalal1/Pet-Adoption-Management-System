package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.ImageDto;
import com.adoptapet.adoptapet.Services.EntityServices.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{petId}")
    public ResponseEntity<List<ImageDto>> getAllImages(@PathVariable int petId) {
        return ResponseEntity.ok(imageService.getAllImages(petId));
    }

    // Let's agree on convention that if imageId is 0, then this is the profile image for carousel
    @GetMapping("/{petId}/{imageId}")
    public ResponseEntity<ImageDto> getImage(@PathVariable int petId, @PathVariable int imageId) {
        System.out.println(petId);
        System.out.println(imageId);
        return ResponseEntity.ok(imageService.getImage(petId, imageId));
    }

    @PostMapping
    public ResponseEntity<String> addImage(@RequestBody ImageDto imageDto) {
        imageService.addImage(imageDto);
        return ResponseEntity.ok("Image added successfully");
    }

    @DeleteMapping("/{petId}/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable int petId, @PathVariable int imageId) {
        imageService.deleteImage(petId, imageId);
        return ResponseEntity.ok("Image deleted successfully");
    }
}
