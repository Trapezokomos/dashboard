package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends BaseDocument {
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
