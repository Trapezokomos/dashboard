package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaymentResource extends BaseResource {
    private Double amount;
    private Date date;
    private String status;
    private Long reservationConsumerId;
}
