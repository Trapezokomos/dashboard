package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.ReservationResource;
import net.trapezokomos.dashboard.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservation")
@Tag(name = "Reservation", description = "Basic operations for reservations.")
@RequiredArgsConstructor
public class ReservationController {
    
    private final ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<Page<ReservationResource>> getReservations(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(reservationService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResource> getReservation(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(reservationService.get(id));
    }

    @PostMapping
    public ResponseEntity<ReservationResource> createReservation(@RequestBody @Valid ReservationResource ReservationResource) throws GenericException {
        return ResponseEntity.ok(reservationService.save(ReservationResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResource> updateReservation(
            @PathVariable(value = "id") Long id,
            @RequestBody ReservationResource ReservationResource
    ) {
        return ResponseEntity.ok(reservationService.update(ReservationResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(
            @PathVariable(value = "id") Long id
    ) {
        reservationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
