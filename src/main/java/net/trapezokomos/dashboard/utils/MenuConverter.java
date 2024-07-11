package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.Menu;
import net.trapezokomos.dashboard.resources.MenuResource;
import org.springframework.stereotype.Component;

@Component
@Converter
public class MenuConverter implements AttributeConverter<MenuResource, Menu> {

    @Override
    public Menu convertToDatabaseColumn(MenuResource menuResource) {
        return Menu.builder()
                .id(menuResource.getId())
                .name(menuResource.getName())
                .storeId(menuResource.getStoreId())
                .createdAt(menuResource.getCreatedAt())
                .updatedAt(menuResource.getUpdatedAt())
                .build();
    }

    @Override
    public MenuResource convertToEntityAttribute(Menu menu) {
        return MenuResource.builder()
                .id(menu.getId())
                .name(menu.getName())
                .storeId(menu.getStoreId())
                .createdAt(menu.getCreatedAt())
                .updatedAt(menu.getUpdatedAt())
                .build();
    }

    public MenuResource createMenuResource(String name, int storeId) {
        return MenuResource.builder()
                .name(name)
                .storeId(storeId)
                .build();
    }
}
