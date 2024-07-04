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
@Table(name = "billing_details")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BillingDetails extends AbstractEntity {
    @Column(
            name = "store_id",
            nullable = false
    )
    private int storeId;
}
