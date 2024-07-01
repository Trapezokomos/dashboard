package net.trapezokomos.dashboard.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConsumerResource extends BaseResource {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
