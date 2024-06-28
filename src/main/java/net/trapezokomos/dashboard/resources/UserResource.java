package net.trapezokomos.dashboard.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.trapezokomos.dashboard.data.Role;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserResource extends AbstractResource {
        private String username;
        private String email;
        private String first_name;
        private String last_name;
        private String phone_number;
        private int customerId;
        private Set<Role> roles;
}
