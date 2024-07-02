package net.trapezokomos.dashboard.resources;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.trapezokomos.dashboard.data.Role;

@Setter
@Getter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserResource extends BaseResource {
        private String email;
        private String password;
        private String first_name;
        private String last_name;
        private String phone_number;
        private int customerId;
        private Role role;
}
