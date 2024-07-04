package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.trapezokomos.dashboard.resources.MenuResource;
import net.trapezokomos.dashboard.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu")
@Tag(name = "Menu", description = "Basic operations for menus.")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<MenuResource>> getMenus(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(menuService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity getMenu(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            return ResponseEntity.ok(menuService.get(id));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity updateMenu(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody MenuResource menuResource
    ) {
        try {
            return ResponseEntity.ok(menuService.update(menuResource, id));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity createMenu(@RequestBody MenuResource menuResource) {
        try {
            return ResponseEntity.ok(menuService.save(menuResource));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMenu(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            menuService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }
}
