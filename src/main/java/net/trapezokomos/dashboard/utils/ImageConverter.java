package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Image;
import net.trapezokomos.dashboard.resources.ImageResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ImageConverter implements AttributeConverter<ImageResource, Image> {

    @Override
    public Image convertToDatabaseColumn(ImageResource imageResource) {
        return Image.builder()
                .id(imageResource.getId())
                .name(imageResource.getName())
                .type(imageResource.getType())
                .picByte(imageResource.getByte())
                .srclink(imageResource.getSrclink())
                .store_id(imageResource.getStore_id())
                .createdAt(imageResource.getCreatedAt())
                .updatedAt(imageResource.getUpdatedAt())
                .build();
    }

    @Override
    public ImageResource convertToEntityAttribute(Image image) {
        return ImageResource.builder()
                .id(image.getId())
                .name(image.getName())
                .type(image.getType())
                .Byte(image.getPicByte())
                .srclink(image.getSrclink())
                .store_id(image.getStore_id())
                .createdAt(image.getCreatedAt())
                .updatedAt(image.getUpdatedAt())
                .build();
    }

    public ImageResource createImageResource(String name, String type, byte[] Byte, String srclink, int store_id, Date createdAt, Date updatedAt) {
        return ImageResource.builder()
                .name(name)
                .type(type)
                .Byte(Byte)
                .srclink(srclink)
                .store_id(store_id)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
