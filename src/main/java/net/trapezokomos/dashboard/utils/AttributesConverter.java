package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.Attribute;
import net.trapezokomos.dashboard.resources.AttributeResource;
import org.springframework.stereotype.Component;

@Component
@Converter
public class AttributesConverter implements AttributeConverter<AttributeResource, Attribute> {

    @Override
    public Attribute convertToDatabaseColumn(AttributeResource attributeResource) {
        return Attribute.builder()
                .id(attributeResource.getId())
                .name(attributeResource.getName())
                .type(attributeResource.getType())
                .value(attributeResource.getValue())
                .storeId(attributeResource.getStoreId())
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
                .value(attribute.getValue())
                .storeId(attribute.getStoreId())
                .createdAt(attribute.getCreatedAt())
                .updatedAt(attribute.getUpdatedAt())
                .build();
    }

    public AttributeResource createAttributeResource(String name, String type, int store_id, String value) {
        return AttributeResource.builder()
                .name(name)
                .type(type)
                .storeId(store_id)
                .value(value)
                .build();
    }

}
