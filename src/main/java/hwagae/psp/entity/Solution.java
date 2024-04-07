package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorColumn
public abstract class Solution extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    private String comment;//해설

    @OneToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
}
