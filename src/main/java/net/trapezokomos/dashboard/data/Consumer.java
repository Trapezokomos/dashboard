package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Entity
@Table(
        name = "consumers",
        uniqueConstraints = {
                @UniqueConstraint(name = "consumer_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "consumer_phone_unique", columnNames = "phoneNumber"),
        })
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Consumer extends AbstractEntity {
    @Column(
            name = "username",
            nullable = false
    )
    private String username;
    @Column(
            name = "password",
            nullable = false
    )
    private String password;
    @Column(
            name = "firstName",
            nullable = false
    )
    private String firstName;
    @Column(
            name = "lastName",
            nullable = false
    )
    private String lastName;
    @Column(
            name = "phoneNumber",
            nullable = false
    )
    private String phoneNumber;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
}
