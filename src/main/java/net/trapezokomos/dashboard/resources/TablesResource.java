package net.trapezokomos.dashboard.resources;


import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class TablesResource  extends BaseResource{
    private String name;
    private String description;
    private int store_id;
    private int capacity;
    private String type;
    private boolean availability;
}
