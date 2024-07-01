package net.trapezokomos.dashboard.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReservationResource extends BaseResource {
    private Long consumerId;
    private Long tableId;
    private Date date;
    private Date startTime;
    private Date endTime;
    private Double totalPrice;
    private String status;
}
