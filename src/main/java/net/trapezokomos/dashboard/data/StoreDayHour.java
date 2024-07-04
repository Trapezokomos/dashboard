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
@Table(name = "store_day_hour")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StoreDayHour extends AbstractEntity {
    @Column(
            name = "store_id",
            nullable = false
    )
    private int storeId;
    @Column(
            name = "dayofweek",
            nullable = false
    )
    private int dayOfWeek;
    @Column(
            name = "start_time",
            nullable = false
    )
    private String startTime;
    @Column(
            name = "end_time",
            nullable = false
    )
    private String endTime;
    @Column(
            name = "is_closed",
            nullable = false
    )
    private boolean isClosed;
}
