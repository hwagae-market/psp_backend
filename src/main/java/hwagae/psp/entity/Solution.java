package hwagae.psp.entity;

import hwagae.psp.dto.request.RequestSolutionDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solution extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    private String correct;
    private String comment;//해설

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "problem_id")
    @Setter
    private Problem problem;

    public void update(RequestSolutionDto requestSolutionDto) {
        this.correct = requestSolutionDto.getCorrect();
        this.comment = requestSolutionDto.getComment();
    }
}
