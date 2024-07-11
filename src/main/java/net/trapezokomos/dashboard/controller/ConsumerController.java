package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.ConsumerResource;
import net.trapezokomos.dashboard.service.ConsumerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consumer")
@Tag(name = "Consumer", description = "Basic operations for consumers.")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('CUSTOMER')") // This is a security annotation, we can use it to secure our endpoints
public class ConsumerController {
    
    private final ConsumerService consumerService;

    @GetMapping("/all")
    public ResponseEntity<Page<ConsumerResource>> getConsumers(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(consumerService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumerResource> getConsumer(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(consumerService.get(id));
    }

    @PostMapping
    public ResponseEntity<ConsumerResource> createConsumer(@RequestBody @Valid ConsumerResource ConsumerResource) throws GenericException {
        return ResponseEntity.ok(consumerService.save(ConsumerResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumerResource> updateConsumer(
            @PathVariable(value = "id") Long id,
            @RequestBody ConsumerResource ConsumerResource
    ) {
        return ResponseEntity.ok(consumerService.update(ConsumerResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConsumerResource> deleteConsumer(
            @PathVariable(value = "id") Long id
    ) {
        consumerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
