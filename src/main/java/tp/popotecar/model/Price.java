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
@Table(name = "price", schema = "public")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "price")
    @NotNull
    private Long price;

    @OneToOne
    @JoinColumn(name = "start_step_id", referencedColumnName = "id")
    private Step startStep;

    @OneToOne
    @JoinColumn(name = "end_step_id", referencedColumnName = "id")
    private Step endStep;
}
