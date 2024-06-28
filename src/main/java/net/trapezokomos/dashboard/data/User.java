package net.trapezokomos.dashboard.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "user_phone_unique", columnNames = "phoneNumber"),
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class User extends BaseDocument {
    @Column(
            name = "username",
            nullable = false
    )
    @NotEmpty(message = "Username is required.")
    private String username;
    @JsonIgnore
    @Column(
            name = "password",
            nullable = true
    )
    private String password;
    @Column(
            name = "email",
            nullable = false
    )
    @NotEmpty(message = "Email is required.")
    private String email;
    @Column(
            name = "firstName",
            nullable = false
    )
    @NotEmpty(message = "First name is required.")
    private String firstName;
    @Column(
            name = "lastName",
            nullable = false
    )
    @NotEmpty(message = "Last name is required.")
    private String lastName;
    @Column(
            name = "phoneNumber",
            nullable = true
    )
    private String phoneNumber;
    @Column(
            name = "roles",
            nullable = false
    )
    @NotEmpty(message = "Roles are required.")
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Column(
            name = "customerid",
            nullable = true
    )
    private int customerId;
}
