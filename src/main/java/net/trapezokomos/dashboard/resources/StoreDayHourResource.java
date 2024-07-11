package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StoreDayHourResource extends BaseResource {
    private int storeId;
    private int dayOfWeek;
    private String startTime;
    private String endTime;
    private boolean isClosed;
}
