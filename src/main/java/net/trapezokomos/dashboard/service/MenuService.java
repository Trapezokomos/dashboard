package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.Menu;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.MenuRepository;
import net.trapezokomos.dashboard.resources.MenuResource;
import net.trapezokomos.dashboard.utils.MenuConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MenuService implements BaseService<MenuResource> {
    private final MenuRepository repository;
    @Autowired private MenuConverter menuConverter;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public MenuResource save(MenuResource entity) throws GenericException {
        Menu menu = menuConverter.convertToDatabaseColumn(entity);
        if (repository.existsByName(menu.getName())) {
            throw new GenericException();
        }
        return Optional.of(repository.save(menu)).map(menuConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the menu."));

    }

    @Override
    public void delete(Long id) {
        Menu existingMenu = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the menu."));
        repository.delete(existingMenu);
    }

    @Override
    public Page<MenuResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(menuConverter::convertToEntityAttribute);
    }

    public MenuResource get(Long id) {
        return repository.findById(id)
                .map(menuConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the menu."));
    }

    @Override
    public MenuResource update(MenuResource entity, Long id) {
        Menu existingMenu = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the menu."));
        existingMenu.setName(entity.getName());
        return menuConverter.convertToEntityAttribute(repository.save(existingMenu));
    }
}
