package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.Tables;
import net.trapezokomos.dashboard.resources.TablesResource;
import org.springframework.stereotype.Component;

@Component
@Converter
public class TablesConverter implements AttributeConverter<TablesResource, Tables> {

    @Override
    public Tables convertToDatabaseColumn(TablesResource tablesResource) {
        return Tables.builder()
                .id(tablesResource.getId())
                .name(tablesResource.getName())
                .description(tablesResource.getDescription())
                .storeId(tablesResource.getStoreId())
                .capacity(tablesResource.getCapacity())
                .type(tablesResource.getType())
                .availability(tablesResource.isAvailability())
                .createdAt(tablesResource.getCreatedAt())
                .updatedAt(tablesResource.getUpdatedAt())
                .build();
    }

    @Override
    public TablesResource convertToEntityAttribute(Tables tables) {
        return TablesResource.builder()
                .id(tables.getId())
                .name(tables.getName())
                .description(tables.getDescription())
                .storeId(tables.getStoreId())
                .capacity(tables.getCapacity())
                .type(tables.getType())
                .availability(tables.isAvailability())
                .createdAt(tables.getCreatedAt())
                .updatedAt(tables.getUpdatedAt())
                .build();
    }

    public TablesResource createTablesResource(String name, String description, int storeId, int capacity, String type, boolean availability) {
        return TablesResource.builder()
                .name(name)
                .description(description)
                .storeId(storeId)
                .capacity(capacity)
                .type(type)
                .availability(availability)
                .build();
    }
}
