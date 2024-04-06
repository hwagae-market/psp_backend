package hwagae.psp.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("subjective")
public class SubjectiveSolution extends Solution {
    private String answer;
}
