package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.AttributeResource;
import net.trapezokomos.dashboard.service.AttributeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/attribute")
@Tag(name = "Attribute", description = "Basic operations for attributes.")
@RequiredArgsConstructor
public class AttributeController {

    private final AttributeService attributeService;

    @GetMapping("/all")
    public ResponseEntity<Page<AttributeResource>> getAttributes(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(attributeService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeResource> getAttribute(
            @PathVariable(value = "id", required = true) Long id
    ) {
        return ResponseEntity.ok(attributeService.get(id));
    }

    @PostMapping
    public ResponseEntity<AttributeResource> createAttribute(@RequestBody @Valid AttributeResource attributeResource) throws GenericException {
        return ResponseEntity.ok(attributeService.save(attributeResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeResource> updateAttribute(
            @PathVariable(value = "id") Long id,
            @RequestBody AttributeResource attributeResource
    ) {
        return ResponseEntity.ok(attributeService.update(attributeResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(
            @PathVariable(value = "id") Long id
    ) {
        attributeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
