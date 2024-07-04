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
@Table(name = "tables")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Tables  extends AbstractEntity{
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @Column(
            name = "store_id",
            nullable = false
    )
    private int store_id;

    @Column(
            name = "capacity",
            nullable = false
    )
    private int capacity;

    @Column(
            name = "type",
            nullable = false
    )
    private String type;

    @Column(
            name = "availability",
            nullable = false
    )
    private boolean availability;
}
