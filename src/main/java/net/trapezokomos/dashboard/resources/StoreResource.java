package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StoreResource extends BaseResource {
    private String name;
    private String address;
    private String description;
    private String slotTimeAvailable;
    private int customerId;
}
