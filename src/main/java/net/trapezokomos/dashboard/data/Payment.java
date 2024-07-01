package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Payment extends AbstractEntity {
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "reservationconsumerid", nullable = false)
    private Long reservationConsumerId;
}
