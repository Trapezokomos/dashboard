package net.trapezokomos.dashboard.service;

import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.data.Tables;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.TablesRepository;
import net.trapezokomos.dashboard.resources.TablesResource;
import net.trapezokomos.dashboard.utils.TablesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TablesService implements BaseService<TablesResource> {

    private final TablesRepository repository;
    @Autowired
    private TablesConverter tablesConverter;

    @Override
    public TablesResource save(TablesResource entity) throws GenericException {
        Tables table = tablesConverter.convertToDatabaseColumn(entity);
        if (repository.existsByName(table.getName())) {
            throw new GenericException();
        }
        table.setCreatedAt(new Date());
        table.setUpdatedAt(new Date());
        return Optional.of(repository.save(table)).map(tablesConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the table."));
    }

    @Override
    public void delete(Long id) {
        Tables existingTables = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the table."));
        repository.delete(existingTables);
    }

    @Override
    public Page<TablesResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(tablesConverter::convertToEntityAttribute);
    }

    public TablesResource get(Long id) {
        return repository.findById(id)
                .map(tablesConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the table."));
    }

    @Override
    public TablesResource update(TablesResource entity, Long id) {
        Tables existingTables = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the table."));
        existingTables.setName(entity.getName());
        existingTables.setDescription(entity.getDescription());
        existingTables.setStoreId(entity.getStoreId());
        existingTables.setCapacity(entity.getCapacity());
        existingTables.setType(entity.getType());
        existingTables.setAvailability(entity.isAvailability());
        existingTables.setUpdatedAt(new Date());
        return tablesConverter.convertToEntityAttribute(repository.save(existingTables));
    }
}
