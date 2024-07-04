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
public class FeedbackResource extends BaseResource {
    private int userId;
    private int storeId;
    private int rating;
    private String comment;
    private Date date;
}
