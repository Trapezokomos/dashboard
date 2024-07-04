package net.trapezokomos.dashboard.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import net.trapezokomos.dashboard.resources.TablesResource;
import net.trapezokomos.dashboard.service.TablesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tables")
@Tag(name = "Tables", description = "Basic operations for tables.")
public class TablesController {
    private final TablesService tablesService;

    public TablesController(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<TablesResource>> getTables(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(tablesService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity getTable(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            return ResponseEntity.ok(tablesService.get(id));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity updateTable(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody TablesResource tablesResource
    ) {
        try {
            return ResponseEntity.ok(tablesService.update(tablesResource, id));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity createTable(@RequestBody TablesResource tablesResource) {
        try {
            return ResponseEntity.ok(tablesService.save(tablesResource));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTable(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            tablesService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

}
