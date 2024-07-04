package net.trapezokomos.dashboard.resources;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AttributeResource extends  BaseResource{
    private String name;
    private String description;
    private String type;
    private int store_id;
}
