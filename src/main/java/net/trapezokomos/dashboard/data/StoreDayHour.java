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
public class StoreDayHour  extends AbstractEntity{
    @Column(
            name = "store_id",
            nullable = false
    )
    private int store_id;
    @Column(
            name = "dayofweek",
            nullable = false
    )
    private int dayofweek;

    @Column(
            name = "start_time",
            nullable = false
    )
    private String start_time;

    @Column(
            name = "end_time",
            nullable = false
    )
    private String end_time;

    @Column(
            name = "cloded",
            nullable = false
    )
    private boolean cloded;
}
