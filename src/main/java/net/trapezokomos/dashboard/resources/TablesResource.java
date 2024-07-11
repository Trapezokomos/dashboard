package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TablesResource extends BaseResource {
    private String name;
    private String description;
    private int storeId;
    private int capacity;
    private String type;
    private boolean availability;
}
