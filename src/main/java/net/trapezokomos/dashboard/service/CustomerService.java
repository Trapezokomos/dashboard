package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.Customer;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.repository.CustomerRepository;
import net.trapezokomos.dashboard.resources.CustomerResource;
import net.trapezokomos.dashboard.utils.CustomerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerService implements BaseService<CustomerResource> {

    private final CustomerRepository repository;
    @Autowired private CustomerConverter customerConverter;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public CustomerResource save(CustomerResource entity) throws GenericException {
        Customer customer = customerConverter.convertToDatabaseColumn(entity);
        if (repository.existsByName(customer.getName())) {
            throw new GenericException();
        }
        return Optional.of(repository.save(customer)).map(customerConverter::convertToEntityAttribute).orElseThrow(() -> new RuntimeException("Could not create the customer."));
    }

    @Override
    public void delete(Long id) {
        Customer existingCustomer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the customer."));
        repository.delete(existingCustomer);
    }

    @Override
    public Page<CustomerResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(customerConverter::convertToEntityAttribute);
    }

    public CustomerResource get(Long id) {
        return repository.findById(id)
                .map(customerConverter::convertToEntityAttribute)
                .orElseThrow(() -> new RuntimeException("Could not find the customer."));
    }

    @Override
    public CustomerResource update(CustomerResource entity, Long id) {
        Customer existingCustomer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the customer."));
        existingCustomer.setName(entity.getName());
        existingCustomer.setPhoneNumber(entity.getPhoneNumber());
        existingCustomer.setUpdatedAt(new Date());
        return Optional.of(repository.save(existingCustomer)).map(customerConverter::convertToEntityAttribute).orElseThrow(() -> new RuntimeException("Could not update the customer."));
    }
}
