package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class StoreResource extends BaseResource{
    private String name;
    private String address;
    private String description;
    private String slottimeavailable;
    private int customer_id;
}
