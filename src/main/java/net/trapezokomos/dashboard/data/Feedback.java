package net.trapezokomos.dashboard.data;


import jakarta.persistence.Column;
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
    @Column(
           name = "user_id",
           nullable = false
    )
    private int user_id;
    @Column(
            name = "store_id",
            nullable = false
    )
    private int store_id;
    @Column(
            name = "rating",
            nullable = false
    )
    private int rating;
    @Column(
            name = "comment",
            nullable = false
    )
    private String comment;
    @Column(
            name = "date",
            nullable = false
    )
    private Date date;
}
