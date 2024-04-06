package hwagae.psp.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("multiple")
public class MultipleSolution extends Solution {
    private int answer;
}
