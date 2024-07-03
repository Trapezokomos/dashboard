package net.trapezokomos.dashboard.resources;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class StoreResource extends BaseResource{
    private String name;
    private String address;


}
