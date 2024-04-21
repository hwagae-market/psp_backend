package hwagae.psp.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DiscriminatorValue("multiple")
@NoArgsConstructor
public class MultipleProblem extends Problem {
    @OneToMany
    List<ChoiceOption> choiceOptions = new ArrayList<>();
}