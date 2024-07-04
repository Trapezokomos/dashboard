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
@Table(name = "attributes")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Attribute extends AbstractEntity {
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "type",
            nullable = false
    )
    private String type;
    @Column(
            name = "store_id",
            nullable = false
    )
    private int storeId;
    @Column(
            name = "value",
            nullable = false
    )
    private String value;
}
