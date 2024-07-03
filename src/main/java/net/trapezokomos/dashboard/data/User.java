package net.trapezokomos.dashboard.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "user_phone_unique", columnNames = "phone_number"),
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class User extends AbstractEntity implements UserDetails {
    @Column(
            name = "password",
            nullable = true
    )
    @NotEmpty(message = "Password is required.")
    private String password;
    @Column(
            name = "email",
            nullable = false
    )
    @NotEmpty(message = "Email is required.")
    private String email;
    @Column(
            name = "first_name",
            nullable = true
    )
    @NotEmpty(message = "First name is required.")
    private String firstName;
    @Column(
            name = "last_name",
            nullable = true
    )
    @NotEmpty(message = "Last name is required.")
    private String lastName;
    @Column(
            name = "phone_number",
            nullable = true
    )
    private String phoneNumber;
    @Column(
            name = "customer_id",
            nullable = false
    )
    private int customerId;
    @Column(
            name = "role",
            nullable = false
    )
    @NotEmpty(message = "Roles are required.")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
