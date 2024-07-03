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
@Table(name = "stores")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Store  extends  AbstractEntity{
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "address",
            nullable = false
    )
    private String address;

}
