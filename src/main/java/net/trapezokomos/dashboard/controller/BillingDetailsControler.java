package net.trapezokomos.dashboard.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import net.trapezokomos.dashboard.resources.BillingDetailsResource;
import net.trapezokomos.dashboard.service.BillingDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/billing-details")
@Tag(name = "Billing Details", description = "Basic operations for billing details.")
public class BillingDetailsControler {
    private final BillingDetailsService billingDetailsService;

    public BillingDetailsControler(BillingDetailsService billingDetailsService) {
        this.billingDetailsService = billingDetailsService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<BillingDetailsResource>> getBillingDetails(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(billingDetailsService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity getBillingDetail(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            return ResponseEntity.ok(billingDetailsService.get(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createBillingDetail(@RequestBody BillingDetailsResource billingDetailsResource) {
        try {
            return ResponseEntity.ok(billingDetailsService.save(billingDetailsResource));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity updateBillingDetail(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody BillingDetailsResource billingDetailsResource
    ) {
        try {
            return ResponseEntity.ok(billingDetailsService.update(billingDetailsResource, id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBillingDetail(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            billingDetailsService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

}
