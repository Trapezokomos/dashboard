package net.trapezokomos.dashboard.resources;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode
@Getter
@Setter
@SuperBuilder
public class BaseResource {
    private Long id;
    private int version;
    private Date createdAt;
    private Date updatedAt;
}
