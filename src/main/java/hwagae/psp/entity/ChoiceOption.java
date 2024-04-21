package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@DiscriminatorValue("multiple")
@NoArgsConstructor
public class ChoiceOption {
    @Id
    @GeneratedValue
    private Long id;
    private Integer optionNum;
    private String optionContent;

    @ManyToOne
    private MultipleProblem multipleProblem;
}
