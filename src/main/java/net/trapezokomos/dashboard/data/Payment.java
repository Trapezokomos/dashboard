package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment extends BaseDocument {
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "reservationconsumerid", nullable = false)
    private Long reservationConsumerId;
}
