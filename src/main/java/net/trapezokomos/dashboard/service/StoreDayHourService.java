package net.trapezokomos.dashboard.service;


import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.data.StoreDayHour;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.StoreDayHourRepository;
import net.trapezokomos.dashboard.resources.StoreDayHourResource;
import net.trapezokomos.dashboard.utils.StoreDayHourConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreDayHourService implements BaseService<StoreDayHourResource> {

    private final StoreDayHourRepository repository;
    private final StoreDayHourConverter storeDayHourConverter;

    @Override
    public StoreDayHourResource save(StoreDayHourResource entity) throws GenericException {
        StoreDayHour storeDayHour = storeDayHourConverter.convertToDatabaseColumn(entity);
        storeDayHour.setCreatedAt(new Date());
        storeDayHour.setUpdatedAt(new Date());
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
    public StoreDayHourResource update(StoreDayHourResource storeDayHourResource, Long id) {
        StoreDayHour existingStoreDayHour = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the store day hour."));
        existingStoreDayHour.setStoreId(storeDayHourResource.getStoreId());
        existingStoreDayHour.setDayOfWeek(storeDayHourResource.getDayOfWeek());
        existingStoreDayHour.setStartTime(storeDayHourResource.getStartTime());
        existingStoreDayHour.setEndTime(storeDayHourResource.getEndTime());
//        existingStoreDayHour.set(storeDayHourResource.getIsClosed());
        return storeDayHourConverter.convertToEntityAttribute(repository.save(existingStoreDayHour));
    }
}
