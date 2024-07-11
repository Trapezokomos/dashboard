package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Menu extends AbstractEntity {
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "store_id",
            nullable = false
    )
    private int storeId;
}
