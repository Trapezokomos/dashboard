package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.ReservationTransactionResource;
import net.trapezokomos.dashboard.service.ReservationTransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation-transaction")
@Tag(name = "Reservation Transaction", description = "Basic operations for reservation transactions.")
@RequiredArgsConstructor
public class ReservationTransactionController {
    
    private final ReservationTransactionService reservationTransactionService;

    @GetMapping("/all")
    public ResponseEntity<Page<ReservationTransactionResource>> getReservationTransactions(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(reservationTransactionService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationTransactionResource> getReservationTransaction(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(reservationTransactionService.get(id));
    }

    @PostMapping
    public ResponseEntity<ReservationTransactionResource> createReservationTransaction(@RequestBody @Valid ReservationTransactionResource ReservationTransactionResource) throws GenericException {
        return ResponseEntity.ok(reservationTransactionService.save(ReservationTransactionResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationTransactionResource> updateReservationTransaction(
            @PathVariable(value = "id") Long id,
            @RequestBody ReservationTransactionResource ReservationTransactionResource
    ) {
        return ResponseEntity.ok(reservationTransactionService.update(ReservationTransactionResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationTransaction(
            @PathVariable(value = "id") Long id
    ) {
        reservationTransactionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
