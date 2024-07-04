package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Attribute;
import net.trapezokomos.dashboard.resources.AttributeResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AttributesConverter implements AttributeConverter<AttributeResource, Attribute> {


    @Override
    public Attribute convertToDatabaseColumn(AttributeResource attributeResource) {
        return Attribute.builder()
                .id(attributeResource.getId())
                .name(attributeResource.getName())
                .type(attributeResource.getType())
                .store_id(attributeResource.getStore_id())
                .createdAt(attributeResource.getCreatedAt())
                .updatedAt(attributeResource.getUpdatedAt())
                .build();
    }

    @Override
    public AttributeResource convertToEntityAttribute(Attribute attribute) {
        return AttributeResource.builder()
                .id(attribute.getId())
                .name(attribute.getName())
                .type(attribute.getType())
                .store_id(attribute.getStore_id())
                .createdAt(attribute.getCreatedAt())
                .updatedAt(attribute.getUpdatedAt())
                .build();
    }

    public AttributeResource createAttributeResource(String name, String type, int store_id, Date createdAt, Date updatedAt) {
        return AttributeResource.builder()
                .name(name)
                .type(type)
                .store_id(store_id)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

}
