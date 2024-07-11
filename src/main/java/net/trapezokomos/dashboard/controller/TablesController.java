package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.TablesResource;
import net.trapezokomos.dashboard.service.TablesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tables")
@Tag(name = "Tables", description = "Basic operations for tables.")
@RequiredArgsConstructor
public class TablesController {

    private final TablesService tablesService;

    @GetMapping("/all")
    public ResponseEntity<Page<TablesResource>> getTables(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(tablesService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablesResource> getTable(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(tablesService.get(id));
    }

    @PostMapping
    public ResponseEntity<TablesResource> updateTable(
            @PathVariable(value = "id") Long id,
            @RequestBody TablesResource tablesResource
    ) {
        return ResponseEntity.ok(tablesService.update(tablesResource, id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TablesResource> createTable(@RequestBody TablesResource tablesResource) throws GenericException {
        return ResponseEntity.ok(tablesService.save(tablesResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(
            @PathVariable(value = "id") Long id
    ) {
        tablesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
