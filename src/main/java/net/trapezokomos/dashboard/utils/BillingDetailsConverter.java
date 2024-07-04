package net.trapezokomos.dashboard.utils;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.BillingDetails;
import net.trapezokomos.dashboard.resources.BillingDetailsResource;
import org.springframework.stereotype.Component;

@Component
@Converter
public class BillingDetailsConverter implements AttributeConverter<BillingDetailsResource, BillingDetails> {

    @Override
    public BillingDetails convertToDatabaseColumn(BillingDetailsResource billingDetailsResource) {
        return BillingDetails.builder()
                .storeId(billingDetailsResource.getStoreId())
                .createdAt(billingDetailsResource.getCreatedAt())
                .updatedAt(billingDetailsResource.getUpdatedAt())
                .build();
    }

    @Override
    public BillingDetailsResource convertToEntityAttribute(BillingDetails billingDetails) {
        return BillingDetailsResource.builder()
                .storeId(billingDetails.getStoreId())
                .createdAt(billingDetails.getCreatedAt())
                .updatedAt(billingDetails.getUpdatedAt())
                .build();
    }

    public BillingDetailsResource createBillingDetailsResource(int store_id) {
        return BillingDetailsResource.builder()
                .storeId(store_id)
                .build();
    }


}
