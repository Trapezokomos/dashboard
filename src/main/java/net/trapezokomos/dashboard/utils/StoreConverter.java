package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.Store;
import net.trapezokomos.dashboard.resources.StoreResource;
import org.springframework.stereotype.Component;

@Component
@Converter
public class StoreConverter implements AttributeConverter<StoreResource, Store> {

    @Override
    public Store convertToDatabaseColumn(StoreResource storeResource) {
        return Store.builder()
                .id(storeResource.getId())
                .name(storeResource.getName())
                .address(storeResource.getAddress())
                .description(storeResource.getDescription())
                .slotTimeAvailable(storeResource.getSlotTimeAvailable())
                .customerId(storeResource.getCustomerId())
                .createdAt(storeResource.getCreatedAt())
                .updatedAt(storeResource.getUpdatedAt())
                .build();

    }

    @Override
    public StoreResource convertToEntityAttribute(Store store) {
        return StoreResource.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .description(store.getDescription())
                .slotTimeAvailable(store.getSlotTimeAvailable())
                .customerId(store.getCustomerId())
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt())
                .build();
    }

    public StoreResource createStoreResource(String name, String address, String description, String slotTimeAvailable, int customerId) {
        return StoreResource.builder()
                .name(name)
                .address(address)
                .description(description)
                .slotTimeAvailable(slotTimeAvailable)
                .customerId(customerId)
                .build();
    }
}
