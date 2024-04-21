package hwagae.psp.entity;

import hwagae.psp.entity.com.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@DiscriminatorColumn(name = "type")
public class Problem{

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "problem")
    @Setter
    private Solution solution;

    @OneToMany
    private List<ChoiceOption> options = new ArrayList<>();

    @ManyToOne
    private User user;

    @ManyToOne
    private SubCategory subCategory;
}