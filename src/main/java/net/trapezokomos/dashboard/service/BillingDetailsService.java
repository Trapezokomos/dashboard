package net.trapezokomos.dashboard.service;


import net.trapezokomos.dashboard.data.BillingDetails;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.repository.BillingDetailsRepository;
import net.trapezokomos.dashboard.resources.BillingDetailsResource;
import net.trapezokomos.dashboard.utils.BillingDetailsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingDetailsService implements BaseService<BillingDetailsResource> {

    private final BillingDetailsRepository repository;
    @Autowired private BillingDetailsConverter billingDetailsConverter;

public BillingDetailsService(BillingDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public BillingDetailsResource save(BillingDetailsResource entity)  throws GenericException{
        BillingDetails billingDetails = billingDetailsConverter.convertToDatabaseColumn(entity);
//        if (repository.existsByStore_id(billingDetails.getStore_id())) {
//            throw new GenericException();
//        }
        return Optional.of(repository.save(billingDetails)).map(billingDetailsConverter::convertToEntityAttribute).orElseThrow(() -> new RuntimeException("Could not create the billing details."));
    }

    @Override
    public void delete(Long id) {
        BillingDetails existingBillingDetails = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the billing details."));
        repository.delete(existingBillingDetails);
    }
    @Override
    public Page<BillingDetailsResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(billingDetailsConverter::convertToEntityAttribute);
    }

    public BillingDetailsResource get(Long id) {
        return repository.findById(id)
                .map(billingDetailsConverter::convertToEntityAttribute)
                .orElseThrow(() -> new RuntimeException("Could not find the billing details."));
    }

    @Override
    public BillingDetailsResource update(BillingDetailsResource entity, Long id) {
        BillingDetails existingBillingDetails = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the billing details."));
        existingBillingDetails.setStore_id(entity.getStore_id());
        existingBillingDetails.setCreatedAt(entity.getCreatedAt());
        existingBillingDetails.setUpdatedAt(entity.getUpdatedAt());
        return billingDetailsConverter.convertToEntityAttribute(repository.save(existingBillingDetails));
    }
}
