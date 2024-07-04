package net.trapezokomos.dashboard.service;

import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.data.Store;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.StoreRepository;
import net.trapezokomos.dashboard.resources.StoreResource;
import net.trapezokomos.dashboard.utils.StoreConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService implements BaseService<StoreResource> {

    private final StoreRepository repository;
    @Autowired
    private StoreConverter storeConverter;

    @Override
    public StoreResource save(StoreResource entity) throws GenericException {
        Store store = storeConverter.convertToDatabaseColumn(entity);
        if (repository.existsByName(store.getName())) {
            throw new GenericException();
        }
        store.setCreatedAt(new Date());
        store.setUpdatedAt(new Date());
        return Optional.of(repository.save(store)).map(storeConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the store."));
    }

    @Override
    public void delete(Long id) {
        Store existingStore = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the store."));
        repository.delete(existingStore);
    }

    @Override
    public Page<StoreResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(storeConverter::convertToEntityAttribute);
    }

    public StoreResource get(Long id) {
        return repository.findById(id)
                .map(storeConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the store."));
    }

    @Override
    public StoreResource update(StoreResource entity, Long id) {
        Store existingStore = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the store."));
        existingStore.setName(entity.getName());
        existingStore.setAddress(entity.getAddress());
        existingStore.setDescription(entity.getDescription());
        existingStore.setSlotTimeAvailable(entity.getSlotTimeAvailable());
        existingStore.setCustomerId(entity.getCustomerId());
        existingStore.setUpdatedAt(new Date());
        return Optional.of(repository.save(existingStore)).map(storeConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not update the store."));
    }
}
