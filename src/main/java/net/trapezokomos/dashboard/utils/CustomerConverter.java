package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Customer;
import net.trapezokomos.dashboard.resources.CustomerResource;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter implements AttributeConverter<CustomerResource, Customer> {

    @Override
    public Customer convertToDatabaseColumn(CustomerResource customerResource) {
        return Customer.builder()
                .id(customerResource.getId())
                .name(customerResource.getName())
                .phoneNumber(customerResource.getPhoneNumber())
                .createdAt(customerResource.getCreatedAt())
                .updatedAt(customerResource.getUpdatedAt())
                .version(customerResource.getVersion())
                .build();
    }

    @Override
    public CustomerResource convertToEntityAttribute(Customer customer) {
        return CustomerResource.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .version(customer.getVersion())
                .build();
    }

    public CustomerResource createCustomerResource(String name, String phoneNumber) {
        return CustomerResource.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .version(1)
                .build();
    }
}
