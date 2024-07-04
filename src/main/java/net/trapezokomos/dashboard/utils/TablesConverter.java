package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Tables;
import net.trapezokomos.dashboard.resources.TablesResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TablesConverter implements AttributeConverter<TablesResource, Tables> {

    @Override
    public Tables convertToDatabaseColumn(TablesResource tablesResource) {
        return Tables.builder()
                .id(tablesResource.getId())
                .name(tablesResource.getName())
                .description(tablesResource.getDescription())
                .store_id(tablesResource.getStore_id())
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
                .store_id(tables.getStore_id())
                .capacity(tables.getCapacity())
                .type(tables.getType())
                .availability(tables.isAvailability())
                .createdAt(tables.getCreatedAt())
                .updatedAt(tables.getUpdatedAt())
                .build();
    }

    public TablesResource createTablesResource(String name, String description, int store_id, int capacity, String type, boolean availability, Date createdAt, Date updatedAt) {
        return TablesResource.builder()
                .name(name)
                .description(description)
                .store_id(store_id)
                .capacity(capacity)
                .type(type)
                .availability(availability)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
