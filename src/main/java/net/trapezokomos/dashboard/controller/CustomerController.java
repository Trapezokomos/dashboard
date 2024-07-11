package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.CustomerResource;
import net.trapezokomos.dashboard.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@Tag(name = "Customer", description = "Basic operations for customers.")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<Page<CustomerResource>> getCustomers(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(customerService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResource> getCustomer(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(customerService.get(id));
    }

    @PostMapping
    public ResponseEntity<CustomerResource> createCustomer(@RequestBody @Valid CustomerResource customerResource) throws GenericException {
        return ResponseEntity.ok(customerService.save(customerResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResource> updateCustomer(
            @PathVariable(value = "id") Long id,
            @RequestBody CustomerResource customerResource
    ) {
        return ResponseEntity.ok(customerService.update(customerResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable(value = "id") Long id
    ) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
