package net.trapezokomos.dashboard.resources;
import lombok.*;
import lombok.experimental.SuperBuilder;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class StoreDayHourResource  extends BaseResource{
    private int store_id;
    private int dayofweek;
    private String start_time;
    private String end_time;
    private boolean cloded;
}
