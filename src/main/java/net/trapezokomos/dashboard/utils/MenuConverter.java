package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Menu;
import net.trapezokomos.dashboard.resources.MenuResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MenuConverter implements AttributeConverter<MenuResource, Menu> {

    @Override
    public Menu convertToDatabaseColumn(MenuResource menuResource) {
        return Menu.builder()
                .id(menuResource.getId())
                .name(menuResource.getName())
                .store_id(menuResource.getStore_id())
                .createdAt(menuResource.getCreatedAt())
                .updatedAt(menuResource.getUpdatedAt())
                .build();
    }

    @Override
    public MenuResource convertToEntityAttribute(Menu menu) {
        return MenuResource.builder()
                .id(menu.getId())
                .name(menu.getName())
                .store_id(menu.getStore_id())
                .createdAt(menu.getCreatedAt())
                .updatedAt(menu.getUpdatedAt())
                .build();
    }

    public MenuResource createMenuResource(String name, int store_id, Date createdAt, Date updatedAt) {
        return MenuResource.builder()
                .name(name)
                .store_id(store_id)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
