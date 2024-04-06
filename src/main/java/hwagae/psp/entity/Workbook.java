package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Workbook extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Problem> problemList;

    @OneToOne
    private Category category;


}
