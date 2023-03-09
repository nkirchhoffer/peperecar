package tp.popotecar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location", schema = "public")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "zip_code")
    @NotNull
    private String zipCode;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "country")
    @NotNull
    private String country;
}
