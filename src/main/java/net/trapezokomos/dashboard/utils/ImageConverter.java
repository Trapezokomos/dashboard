package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.Image;
import net.trapezokomos.dashboard.resources.ImageResource;
import org.springframework.stereotype.Component;

@Component
@Converter
public class ImageConverter implements AttributeConverter<ImageResource, Image> {

    @Override
    public Image convertToDatabaseColumn(ImageResource imageResource) {
        return Image.builder()
                .id(imageResource.getId())
                .name(imageResource.getName())
                .type(imageResource.getType())
                .picByte(imageResource.getByte())
                .srcLink(imageResource.getSrcLink())
                .storeId(imageResource.getStoreId())
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
                .srcLink(image.getSrcLink())
                .storeId(image.getStoreId())
                .createdAt(image.getCreatedAt())
                .updatedAt(image.getUpdatedAt())
                .build();
    }

    public ImageResource createImageResource(String name, String type, byte[] Byte, String srcLink, int storeId) {
        return ImageResource.builder()
                .name(name)
                .type(type)
                .Byte(Byte)
                .srcLink(srcLink)
                .storeId(storeId)
                .build();
    }
}
