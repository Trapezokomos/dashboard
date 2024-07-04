package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.trapezokomos.dashboard.data.Role;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserResource extends BaseResource {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int customerId;
    private Role role;
}
