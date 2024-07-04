package net.trapezokomos.dashboard.service;


import net.trapezokomos.dashboard.data.StoreDayHour;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.StoreDayHourRepository;
import net.trapezokomos.dashboard.resources.StoreDayHourResource;
import net.trapezokomos.dashboard.utils.StoreDayHourConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreDayHourService implements BaseService<StoreDayHourResource> {
    private final StoreDayHourRepository repository;
    @Autowired private StoreDayHourConverter storeDayHourConverter;

    public StoreDayHourService(StoreDayHourRepository repository) {
        this.repository = repository;
    }

    @Override
    public StoreDayHourResource save(StoreDayHourResource entity) throws GenericException {
        StoreDayHour storeDayHour = storeDayHourConverter.convertToDatabaseColumn(entity);
        return Optional.of(repository.save(storeDayHour)).map(storeDayHourConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the store day hour."));
    }

    @Override
    public void delete(Long id) {
        StoreDayHour existingStoreDayHour = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the store day hour."));
        repository.delete(existingStoreDayHour);
    }

    @Override
    public Page<StoreDayHourResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(storeDayHourConverter::convertToEntityAttribute);
    }

    public StoreDayHourResource get(Long id) {
        return repository.findById(id)
                .map(storeDayHourConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the store day hour."));
    }

    @Override
    public StoreDayHourResource update(StoreDayHourResource entity, Long id) {
        StoreDayHour existingStoreDayHour = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the store day hour."));
        existingStoreDayHour.setStore_id(entity.getStore_id());
        existingStoreDayHour.setDayofweek(entity.getDayofweek());
        existingStoreDayHour.setStart_time(entity.getStart_time());
        existingStoreDayHour.setEnd_time(entity.getEnd_time());
        existingStoreDayHour.setCloded(entity.isCloded());
        return storeDayHourConverter.convertToEntityAttribute(repository.save(existingStoreDayHour));
    }
}
