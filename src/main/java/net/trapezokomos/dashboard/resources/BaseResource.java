package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResource {
    private Long id;
    private int version;
    private Date createdAt;
    private Date updatedAt;
}
