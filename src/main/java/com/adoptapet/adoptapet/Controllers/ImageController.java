package com.adoptapet.adoptapet.Controllers;

import com.adoptapet.adoptapet.Dtos.ImageDto;
import com.adoptapet.adoptapet.Services.EntityServices.ImageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{petId}")
    public void getAllImages(@PathVariable int petId) {
        imageService.getAllImages(petId);
    }

    // Let's agree on convention that if imageId is 0, then this is the profile image for carousel
    @GetMapping("/{petId}/{imageId}")
    public ImageDto getImage(@PathVariable int petId, @PathVariable int imageId) {
        return imageService.getImage(petId, imageId);
    }

    @PostMapping
    public void addImage(@RequestBody ImageDto imageDto) {
        imageService.addImage(imageDto);
    }

    @DeleteMapping("/{petId}/{imageId}")
    public void deleteImage(@PathVariable int petId, @PathVariable int imageId) {
        imageService.deleteImage(petId, imageId);
    }
}
