package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.StoreDayHourResource;
import net.trapezokomos.dashboard.service.StoreDayHourService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store-day-hour")
@Tag(name = "StoreDayHour", description = "Basic operations for store day hour.")
@RequiredArgsConstructor
public class StoreDayHourController {

    private final StoreDayHourService storeDayHourService;

    @GetMapping("/all")
    public ResponseEntity<Page<StoreDayHourResource>> getStoreDayHours(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(storeDayHourService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDayHourResource> getStoreDayHour(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(storeDayHourService.get(id));
    }
    @PostMapping
    public ResponseEntity<StoreDayHourResource> createStoreDayHour(@RequestBody StoreDayHourResource storeDayHourResource) throws GenericException {
        return ResponseEntity.ok(storeDayHourService.save(storeDayHourResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDayHourResource> updateStoreDayHour(
            @PathVariable(value = "id") Long id,
            @RequestBody StoreDayHourResource storeDayHourResource
    ) {
        return ResponseEntity.ok(storeDayHourService.update(storeDayHourResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStoreDayHour(
            @PathVariable(value = "id") Long id
    ) {
        storeDayHourService.delete(id);
        return ResponseEntity.ok().build();
    }
}
