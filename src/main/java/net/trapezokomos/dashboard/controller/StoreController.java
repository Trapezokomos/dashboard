package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.StoreResource;
import net.trapezokomos.dashboard.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
@Tag(name = "Store", description = "Basic operations for stores.")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/all")
    public ResponseEntity<Page<StoreResource>> getStores(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(storeService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResource> getStore(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(storeService.get(id));
    }

    @PostMapping
    public ResponseEntity<StoreResource> createStore(@RequestBody @Valid StoreResource storeResource) throws GenericException {
        return ResponseEntity.ok(storeService.save(storeResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreResource> updateStore(
            @PathVariable(value = "id") Long id,
            @RequestBody StoreResource storeResource
    ) {
        return ResponseEntity.ok(storeService.update(storeResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(
            @PathVariable(value = "id") Long id
    ) {
        storeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
