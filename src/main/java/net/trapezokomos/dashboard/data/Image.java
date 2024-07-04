package net.trapezokomos.dashboard.data;


import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Entity
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Image extends AbstractEntity{
    private String name;
    private String type;
    @Lob
    private byte[] picByte;
    private String srclink;
    private int store_id;

}
