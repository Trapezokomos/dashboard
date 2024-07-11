package net.trapezokomos.dashboard.resources;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BillingDetailsResource extends BaseResource {
    private int storeId;
}
