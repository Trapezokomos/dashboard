package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.Consumer;
import net.trapezokomos.dashboard.exception.ResourceAlreadyExistsException;
import net.trapezokomos.dashboard.repository.ConsumerRepository;
import net.trapezokomos.dashboard.resources.ConsumerResource;
import net.trapezokomos.dashboard.utils.ConsumerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ConsumerService implements BaseService<ConsumerResource> {

    private final ConsumerRepository repository;
    @Autowired private ConsumerConverter consumerConverter;

    public ConsumerService(ConsumerRepository repository) {
        this.repository = repository;
    }


    @Override
    public ConsumerResource save(ConsumerResource entity) throws ResourceAlreadyExistsException {
        Consumer consumer = consumerConverter.convertToEntity(entity);
        if (repository.existsByEmail(consumer.getEmail())) {
            throw new ResourceAlreadyExistsException();
        }
        return Optional.of(repository.save(consumer)).map(consumerConverter::convertToResource).orElseThrow(() -> new RuntimeException("Could not create the consumer."));
    }

    @Override
    public void delete(Long T) {
        Consumer existingConsumer = repository.findById(T)
                .orElseThrow(() -> new RuntimeException("Could not find the consumer."));
        repository.delete(existingConsumer);
    }

    @Override
    public Page<ConsumerResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(consumerConverter::convertToResource);
    }

    @Override
    public ConsumerResource update(ConsumerResource entity, Long T) {
        Consumer existingConsumer = repository.findById(T)
                .orElseThrow(() -> new RuntimeException("Could not find the consumer."));
        existingConsumer.setUsername(entity.getUsername());
        existingConsumer.setPassword(entity.getPassword());
        existingConsumer.setFirstName(entity.getFirstName());
        existingConsumer.setLastName(entity.getLastName());
        existingConsumer.setEmail(entity.getEmail());
        existingConsumer.setPhoneNumber(entity.getPhoneNumber());
        existingConsumer.setUpdatedAt(new Date());
        return Optional.of(repository.save(existingConsumer)).map(consumerConverter::convertToResource).orElseThrow(() -> new RuntimeException("Could not update the consumer."));
    }

    @Override
    public ConsumerResource get(Long T) {
        return repository.findById(T)
                .map(consumerConverter::convertToResource)
                .orElseThrow(() -> new RuntimeException("Could not find the consumer."));
    }
}
