package net.trapezokomos.dashboard.utils;

import net.trapezokomos.dashboard.data.Customer;
import net.trapezokomos.dashboard.resources.CustomerResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerConverter implements BaseConverter<CustomerResource, Customer> {

    @Override
    public CustomerResource convertToResource(Customer entity) {
        CustomerResource resource = new CustomerResource();
        resource.setId(entity.getId());
        resource.setName(entity.getName());
        resource.setPhoneNumber(entity.getPhoneNumber());
        resource.setCreatedAt(entity.getCreatedAt());
        resource.setUpdatedAt(entity.getUpdatedAt());
        return resource;
    }

    @Override
    public Customer convertToEntity(CustomerResource resource) {
        Customer entity = new Customer();
        entity.setId(resource.getId());
        entity.setName(resource.getName());
        entity.setPhoneNumber(resource.getPhoneNumber());
        entity.setCreatedAt(resource.getCreatedAt());
        entity.setUpdatedAt(resource.getUpdatedAt());
        return entity;
    }

    public CustomerResource createCustomerResource(String name, String phoneNumber, Date createdAt, Date updatedAt) {
        CustomerResource resource = new CustomerResource();
        resource.setName(name);
        resource.setPhoneNumber(phoneNumber);
        resource.setCreatedAt(createdAt);
        resource.setUpdatedAt(updatedAt);
        return resource;
    }
}
