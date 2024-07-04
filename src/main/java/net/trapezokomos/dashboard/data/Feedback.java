package net.trapezokomos.dashboard.data;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Entity
@Table(name = "feedback")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Feedback extends AbstractEntity {
    private int user_id;
    private int store_id;
    private int rating;
    private String comments;
    private Date date;



}
