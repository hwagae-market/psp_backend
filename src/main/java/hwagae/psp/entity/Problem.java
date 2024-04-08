package hwagae.psp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hwagae.psp.dto.request.RequestAnswerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@DiscriminatorColumn(name = "type")
public abstract class Problem{

    @Id
    @GeneratedValue
    private Long id;
    private String header;//문제 타이틀
    private String body;//본문 내용

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @Setter
    @JsonIgnore
    private Workbook workbook;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "problem")
    @Setter
    private Solution solution;

    public boolean isRightAnswer(RequestAnswerDto answer) {
        return solution.getCorrect().equals(answer.getSubmitAnswer());
    }
}
