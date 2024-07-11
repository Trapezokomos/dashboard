package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.BillingDetailsResource;
import net.trapezokomos.dashboard.service.BillingDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/billing-details")
@Tag(name = "Billing Details", description = "Basic operations for billing details.")
@RequiredArgsConstructor
public class BillingDetailsController {

    private final BillingDetailsService billingDetailsService;

    @GetMapping("/all")
    public ResponseEntity<Page<BillingDetailsResource>> getBillingDetails(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(billingDetailsService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingDetailsResource> getBillingDetail(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(billingDetailsService.get(id));
    }

    @PostMapping
    public ResponseEntity<BillingDetailsResource> createBillingDetail(@RequestBody BillingDetailsResource billingDetailsResource) throws GenericException {
        return ResponseEntity.ok(billingDetailsService.save(billingDetailsResource));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BillingDetailsResource> updateBillingDetail(
            @PathVariable(value = "id") Long id,
            @RequestBody BillingDetailsResource billingDetailsResource
    ) {
        return ResponseEntity.ok(billingDetailsService.update(billingDetailsResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillingDetail(
            @PathVariable(value = "id") Long id
    ) {
        billingDetailsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
