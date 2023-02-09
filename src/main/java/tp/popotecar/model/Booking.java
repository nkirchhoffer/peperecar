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
@Table(name = "booking", schema = "public")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "validated")
    @NotNull
    private Boolean validated;

    @Column(name = "nb_passenger")
    @NotNull
    private Long ngPassenger;

    @ManyToOne
    @JoinColumn(name="ride_id", referencedColumnName = "id")
    private Ride ride;

    @OneToOne
    @JoinColumn(name = "step_id", referencedColumnName = "id")
    private Step endStep;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
}
