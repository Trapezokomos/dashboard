package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Entity
@Table(name = "reservationtransactions")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ReservationTransaction extends AbstractEntity {
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
