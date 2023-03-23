package tp.popotecar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import tp.popotecar.model.enumeration.Status;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "ride", schema = "public")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "max_passenger")
    @NotNull
    private Long maxPassenger;

    @Column(name = "creation_date")
    @NotNull
    private LocalDate creationDate;

    @Column(name = "last_modification_date")
    private LocalDate lastModificationDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="driver_id", referencedColumnName = "id")
    private User driver;

    @OneToMany(mappedBy="ride")
    private List<Step> steps;
}
