package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.trapezokomos.dashboard.resources.ReservationTransactionResource;
import net.trapezokomos.dashboard.service.ReservationTransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation-transaction")
@Tag(name = "Reservation Transaction", description = "Basic operations for reservation transactions.")
public class ReservationTransactionController {
    
    private final ReservationTransactionService reservationTransactionService;
    
    public ReservationTransactionController(ReservationTransactionService reservationTransactionService) {
        this.reservationTransactionService = reservationTransactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ReservationTransactionResource>> getReservationTransactions(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(reservationTransactionService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity getReservationTransaction(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            return ResponseEntity.ok(reservationTransactionService.get(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createReservationTransaction(@RequestBody @Valid ReservationTransactionResource ReservationTransactionResource) {
        try {
            return ResponseEntity.ok(reservationTransactionService.save(ReservationTransactionResource));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateReservationTransaction(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody ReservationTransactionResource ReservationTransactionResource
    ) {
        try {
            return ResponseEntity.ok(reservationTransactionService.update(ReservationTransactionResource, id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservationTransaction(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            reservationTransactionService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
}
