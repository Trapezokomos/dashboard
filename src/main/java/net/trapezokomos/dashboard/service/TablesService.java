package net.trapezokomos.dashboard.service;

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

import java.util.Optional;

@Service
public class TablesService implements BaseService<TablesResource> {
    private final TablesRepository repository;
    @Autowired private TablesConverter tablesConverter;

    public TablesService(TablesRepository repository) {
        this.repository = repository;
    }

    @Override
    public TablesResource save(TablesResource entity) throws GenericException {
        Tables tables = tablesConverter.convertToDatabaseColumn(entity);
        if (repository.existsByName(tables.getName())) {
            throw new GenericException();
        }
        return Optional.of(repository.save(tables)).map(tablesConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the tables."));
    }

    @Override
    public void delete(Long id) {
        Tables existingTables = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the tables."));
        repository.delete(existingTables);
    }

    @Override
    public Page<TablesResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(tablesConverter::convertToEntityAttribute);
    }

    public TablesResource get(Long id) {
        return repository.findById(id)
                .map(tablesConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the tables."));
    }

    @Override
    public TablesResource update(TablesResource entity, Long id) {
        Tables existingTables = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the tables."));
        existingTables.setName(entity.getName());
        return tablesConverter.convertToEntityAttribute(repository.save(existingTables));
    }
}
