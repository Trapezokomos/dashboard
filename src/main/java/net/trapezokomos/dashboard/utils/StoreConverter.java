package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Store;
import net.trapezokomos.dashboard.resources.StoreResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StoreConverter implements AttributeConverter<StoreResource, Store> {

    @Override
    public Store convertToDatabaseColumn(StoreResource storeResource) {
        return Store.builder()
                .id(storeResource.getId())
                .name(storeResource.getName())
                .address(storeResource.getAddress())
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
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt())
                .build();
    }

    public StoreResource createStoreResource(String name, String address, Date createdAt, Date updatedAt) {
        return StoreResource.builder()
                .name(name)
                .address(address)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }


}
