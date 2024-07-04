package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class CustomerResource extends BaseResource {
    private String name;
    private String phoneNumber;
}
