package hwagae.psp.entity;

import hwagae.psp.dto.response.ResponseProblem;
import hwagae.psp.dto.response.ResponseWorkbookDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workbook extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "workbook", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    private List<Problem> problemList;

    @OneToOne
    private Category category;

}
