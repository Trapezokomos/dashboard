package net.trapezokomos.dashboard.resources;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ImageResource extends BaseResource {
    private String name;
    private String type;
    private byte[] Byte;
    private String srcLink;
    private int storeId;
}
