package net.trapezokomos.dashboard.utils;


import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.BillingDetails;
import net.trapezokomos.dashboard.resources.BillingDetailsResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BillingDetailsConverter implements AttributeConverter<BillingDetailsResource, BillingDetails> {

    @Override
    public BillingDetails convertToDatabaseColumn(BillingDetailsResource billingDetailsResource) {
        return BillingDetails.builder()
                .store_id(billingDetailsResource.getStore_id())
                .createdAt(billingDetailsResource.getCreatedAt())
                .updatedAt(billingDetailsResource.getUpdatedAt())
                .build();
    }
    @Override
    public BillingDetailsResource convertToEntityAttribute(BillingDetails billingDetails) {
        return BillingDetailsResource.builder()
                .store_id(billingDetails.getStore_id())
                .createdAt(billingDetails.getCreatedAt())
                .updatedAt(billingDetails.getUpdatedAt())
                .build();
    }

    public BillingDetailsResource createBillingDetailsResource(int store_id, Date createdAt, Date updatedAt) {
        return BillingDetailsResource.builder()
                .store_id(store_id)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }


}
