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
                .description(storeResource.getDescription())
                .slottimeavailable(storeResource.getSlottimeavailable())
                .customer_id(storeResource.getCustomer_id())
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
                .slottimeavailable(store.getSlottimeavailable())
                .customer_id(store.getCustomer_id())
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt())
                .build();
    }

    public StoreResource createStoreResource(String name, String address, String description, String slottimeavailable, int customer_id, Date createdAt, Date updatedAt) {
        return StoreResource.builder()
                .name(name)
                .address(address)
                .description(description)
                .slottimeavailable(slottimeavailable)
                .customer_id(customer_id)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }


}
