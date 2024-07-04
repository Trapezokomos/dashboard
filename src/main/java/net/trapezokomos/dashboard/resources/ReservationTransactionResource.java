package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ReservationTransactionResource extends BaseResource {
    private String details;
    private Double amount;
    private Long reservationId;
}
