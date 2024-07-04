package net.trapezokomos.dashboard.resources;


import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class FeedbackResource extends BaseResource{
    private int user_id;
    private int store_id;
    private int rating;
    private String comments;
    private String date;
}
