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
@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Reservation extends AbstractEntity {
    @Column(name = "consumer_id", nullable = false)
    private Long consumerId;
    @Column(name = "table_id", nullable = false)
    private Long tableId;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "start_time", nullable = false)
    private Date startTime;
    @Column(name = "end_time", nullable = false)
    private Date endTime;
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
    @Column(name = "status", nullable = false)
    private String status;
}
