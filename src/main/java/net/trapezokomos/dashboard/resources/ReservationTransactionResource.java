package net.trapezokomos.dashboard.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReservationTransactionResource extends BaseResource {
    private String details;
    private Double amount;
    private Long reservationId;
}
