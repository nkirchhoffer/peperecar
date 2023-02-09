package tp.popotecar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    @NotNull
    private LocalDate lastModificationDate;

    @OneToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name="driver_id", referencedColumnName = "id")
    private User driver;

    @OneToOne
    @JoinColumn(name = "first_step_id", referencedColumnName = "id")
    private Step firstStep;
}
