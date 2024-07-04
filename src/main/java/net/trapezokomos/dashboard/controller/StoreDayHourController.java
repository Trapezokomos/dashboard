package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.trapezokomos.dashboard.resources.StoreDayHourResource;
import net.trapezokomos.dashboard.service.StoreDayHourService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store-day-hour")
@Tag(name = "StoreDayHour", description = "Basic operations for store day hour.")
public class StoreDayHourController {
    private final StoreDayHourService storeDayHourService;

    public StoreDayHourController(StoreDayHourService storeDayHourService) {
        this.storeDayHourService = storeDayHourService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<StoreDayHourResource>> getStoreDayHours(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(storeDayHourService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity getStoreDayHour(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            return ResponseEntity.ok(storeDayHourService.get(id));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity createStoreDayHour(@RequestBody StoreDayHourResource storeDayHourResource) {
        try {
            return ResponseEntity.ok(storeDayHourService.save(storeDayHourResource));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateStoreDayHour(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody StoreDayHourResource storeDayHourResource
    ) {
        try {
            return ResponseEntity.ok(storeDayHourService.update(storeDayHourResource, id));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStoreDayHour(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            storeDayHourService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }
}
