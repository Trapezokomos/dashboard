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
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation extends BaseDocument {
    @Column(name = "consumerId", nullable = false)
    private Long consumerId;
    @Column(name = "tableId", nullable = false)
    private Long tableId;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "startTime", nullable = false)
    private Date startTime;
    @Column(name = "endTime", nullable = false)
    private Date endTime;
    @Column(name = "totalPrice", nullable = false)
    private Double totalPrice;
    @Column(name = "status", nullable = false)
    private String status;
}
