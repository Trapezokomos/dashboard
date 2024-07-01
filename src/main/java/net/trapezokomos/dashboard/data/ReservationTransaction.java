package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Entity
@Table(name = "reservationtransactions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationTransaction extends BaseDocument {
    @Column(
            name = "reservation_id",
            nullable = false
    )
    private Long reservationId;
    @Column(
            name = "amount",
            nullable = false
    )
    private Double amount;
    @Column(
            name = "details",
            nullable = false
    )
    private String details;
}
