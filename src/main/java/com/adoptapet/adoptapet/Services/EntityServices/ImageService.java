package com.adoptapet.adoptapet.Services.EntityServices;

import com.adoptapet.adoptapet.Dtos.ImageDto;
import com.adoptapet.adoptapet.Dtos.PetDto;
import com.adoptapet.adoptapet.Entities.Image.Image;
import com.adoptapet.adoptapet.Entities.Image.ImageId;
import com.adoptapet.adoptapet.Exceptions.ImageExceptions.ImageAlreadyExistsException;
import com.adoptapet.adoptapet.Exceptions.ImageExceptions.ImageNotFoundException;
import com.adoptapet.adoptapet.Mappers.ImageMapper;
import com.adoptapet.adoptapet.Mappers.PetMapper;
import com.adoptapet.adoptapet.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;
    private final PetService petService;
    private final PetMapper petMapper;

    @Autowired
    public ImageService(ImageRepository imageRepository, ImageMapper imageMapper, PetService petService, PetMapper petMapper) {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
        this.petService = petService;
        this.petMapper = petMapper;
    }

    public List<ImageDto> getAllImages(int petId) {
        List<Image> images = imageRepository.findAllByPetId(petId);
        return imageMapper.toDtoList(images);
    }

    public ImageDto getImage(int petId, int imageId) {
        PetDto pet = petService.getPet(petId);
        ImageId petImageId = new ImageId(petMapper.toEntity(pet), imageId);
        if (imageRepository.findById(petImageId).isEmpty())
            throw new ImageNotFoundException();
        Image image = imageRepository.findById(petImageId).get();
        return imageMapper.toDto(image);
    }

    public void addImage(ImageDto imageDto) {
        ImageId imageId = new ImageId(petMapper.toEntity(imageDto.getPet()), imageDto.getImageId());
        if (imageRepository.findById(imageId).isPresent())
            throw new ImageAlreadyExistsException();
        Image image = imageMapper.toEntity(imageDto);
        imageRepository.save(image);
    }

    public void deleteImage(int petId, int imageId) {
        PetDto pet = petService.getPet(petId);
        ImageId petImageId = new ImageId(petMapper.toEntity(pet), imageId);
        if (imageRepository.findById(petImageId).isEmpty())
            throw new ImageNotFoundException();
        imageRepository.deleteById(petImageId);
    }
}
