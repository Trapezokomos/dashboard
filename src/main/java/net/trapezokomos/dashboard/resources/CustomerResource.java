package net.trapezokomos.dashboard.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerResource extends BaseResource {
    private String name;
    private String phoneNumber;
}
