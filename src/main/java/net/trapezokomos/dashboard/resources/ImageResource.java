package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ImageResource extends BaseResource{
    private String name;
    private String type;
    private byte[] Byte;
    private String srclink;
    private int store_id;
}
