package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer extends AbstractEntity {
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "phoneNumber",
            nullable = false
    )
    private String phoneNumber;
}
