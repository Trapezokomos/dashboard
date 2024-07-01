package net.trapezokomos.dashboard.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentResource extends BaseResource {
    private Double amount;
    private Date date;
    private String status;
    private Long reservationConsumerId;
}
