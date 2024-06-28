package net.trapezokomos.dashboard.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class AbstractResource {
    private Long id;
    private int version;
    private Date createdAt;
    private Date updatedAt;
}
