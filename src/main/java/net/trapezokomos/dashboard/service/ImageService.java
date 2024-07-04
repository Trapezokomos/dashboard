package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.Image;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.ImageRepository;
import net.trapezokomos.dashboard.resources.ImageResource;
import net.trapezokomos.dashboard.utils.ImageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ImageService implements BaseService<ImageResource> {
    private final ImageRepository repository;
    @Autowired private ImageConverter imageConverter;

    public ImageService(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public ImageResource save(ImageResource entity) throws GenericException {
       Image image = imageConverter.convertToDatabaseColumn(entity);
         if (repository.existsByName(image.getName())) {
              throw new GenericException();
         }
            return Optional.of(repository.save(image)).map(imageConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the image."));

    }
    @Override
    public void delete(Long id) {
        Image existingImage = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the image."));
        repository.delete(existingImage);
    }
    @Override
    public Page<ImageResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(imageConverter::convertToEntityAttribute);
    }
    public ImageResource get(Long id) {
        return repository.findById(id)
                .map(imageConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the image."));
    }
    @Override
    public ImageResource update(ImageResource entity, Long id) {
        Image existingImage = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the image."));
        existingImage.setName(entity.getName());
        existingImage.setType(entity.getType());
        existingImage.setPicByte(entity.getByte());
        existingImage.setSrclink(entity.getSrclink());
        existingImage.setStore_id(entity.getStore_id());
        return imageConverter.convertToEntityAttribute(repository.save(existingImage));
    }
}
