package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategory{

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private MainCategory mainCategory;

    private String name;

    @OneToMany
    private List<Problem> problems;
}