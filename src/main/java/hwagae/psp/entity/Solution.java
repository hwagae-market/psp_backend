package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solution{

    @Id
    @GeneratedValue
    private Long id;
    private String answer;
    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "problem_id")
    @Setter
    private Problem problem;
}
