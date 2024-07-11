package net.trapezokomos.dashboard.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Image extends AbstractEntity {
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "type",
            nullable = false
    )
    private String type;
    @Lob
    @Column(
            name = "pic_byte",
            nullable = false
    )
    private byte[] picByte;
    @Column(
            name = "srclink",
            nullable = false
    )
    private String srcLink;
    @Column(
            name = "store_id",
            nullable = false
    )
    private int storeId;

}
