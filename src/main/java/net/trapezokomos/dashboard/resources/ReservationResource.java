package net.trapezokomos.dashboard.resources;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
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
