package net.trapezokomos.dashboard.service;

import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.data.Attribute;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.AttributeRepository;
import net.trapezokomos.dashboard.resources.AttributeResource;
import net.trapezokomos.dashboard.utils.AttributesConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttributeService implements BaseService<AttributeResource> {

    private final AttributeRepository repository;
    private final AttributesConverter attributesConverter;

    @Override
    public AttributeResource save(AttributeResource entity) throws GenericException {
        Attribute attribute = attributesConverter.convertToDatabaseColumn(entity);
        if (repository.existsByName(attribute.getName())) {
            throw new GenericException();
        }
        attribute.setCreatedAt(new Date());
        attribute.setUpdatedAt(new Date());
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
        existingAttribute.setValue(entity.getValue());
        existingAttribute.setType(entity.getType());
        existingAttribute.setUpdatedAt(new Date());
        return Optional.of(repository.save(existingAttribute)).map(attributesConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not update the attribute."));
    }
}
