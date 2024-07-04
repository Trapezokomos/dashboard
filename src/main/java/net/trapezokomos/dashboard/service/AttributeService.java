package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.Attribute;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.AttributeRepository;
import net.trapezokomos.dashboard.resources.AttributeResource;
import net.trapezokomos.dashboard.utils.AttributesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class AttributeService implements BaseService<AttributeResource> {

    private final AttributeRepository repository;
    @Autowired private AttributesConverter attributesConverter;

    public AttributeService(AttributeRepository repository) {
        this.repository = repository;
    }

    @Override
    public AttributeResource save(AttributeResource entity) throws GenericException {
        Attribute attribute = attributesConverter.convertToDatabaseColumn(entity);
        if (repository.existsByName(attribute.getName())) {
            throw new GenericException();
        }
        return Optional.of(repository.save(attribute)).map(attributesConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the attribute."));

    }

    @Override
    public void delete(Long id) {
        Attribute existingAttribute = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the attribute."));
        repository.delete(existingAttribute);
    }

    @Override
    public Page<AttributeResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(attributesConverter::convertToEntityAttribute);
    }

    public AttributeResource get(Long id) {
        return repository.findById(id)
                .map(attributesConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the attribute."));
    }

    @Override
    public AttributeResource update(AttributeResource entity, Long id) {
        Attribute existingAttribute = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the attribute."));
        existingAttribute.setName(entity.getName());
        existingAttribute.setUpdatedAt(new Date());
        return Optional.of(repository.save(existingAttribute)).map(attributesConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not update the attribute."));
    }
}
