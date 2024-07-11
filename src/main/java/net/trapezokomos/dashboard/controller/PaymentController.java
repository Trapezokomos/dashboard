package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.PaymentResource;
import net.trapezokomos.dashboard.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@Tag(name = "Payment", description = "Basic operations for payments.")
@RequiredArgsConstructor
public class PaymentController {
    
    private final PaymentService paymentService;

    @GetMapping("/all")
    public ResponseEntity<Page<PaymentResource>> getPayments(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(paymentService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResource> getPayment(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(paymentService.get(id));
    }

    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody @Valid PaymentResource PaymentResource) throws GenericException {
        return ResponseEntity.ok(paymentService.save(PaymentResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResource> updatePayment(
            @PathVariable(value = "id") Long id,
            @RequestBody PaymentResource PaymentResource
    ) {
        return ResponseEntity.ok(paymentService.update(PaymentResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(
            @PathVariable(value = "id") Long id
    ) {
        paymentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
