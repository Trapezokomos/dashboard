package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.MenuResource;
import net.trapezokomos.dashboard.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menu")
@Tag(name = "Menu", description = "Basic operations for menus.")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/all")
    public ResponseEntity<Page<MenuResource>> getMenus(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(menuService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuResource> getMenu(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(menuService.get(id));
    }

    @PostMapping
    public ResponseEntity<MenuResource> updateMenu(
            @PathVariable(value = "id") Long id,
            @RequestBody MenuResource menuResource
    ) {
        return ResponseEntity.ok(menuService.update(menuResource, id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuResource> createMenu(@RequestBody MenuResource menuResource) throws GenericException {
        return ResponseEntity.ok(menuService.save(menuResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(
            @PathVariable(value = "id") Long id
    ) {
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
