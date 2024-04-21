package hwagae.psp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hwagae.psp.dto.request.RequestAnswerDto;
import hwagae.psp.dto.request.UpdateProblemDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * 문제 공통 엔티티 -> Multiple, Subjective에서 상속중
 * 양쪽 모두에서 사용되는 경우에만 추가
 */
@Entity
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@DiscriminatorColumn(name = "type")
public abstract class Problem {

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

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complain> complainList;

    public void addComplain(Complain complain) {
        this.complainList.add(complain);
    }

    public boolean isRightAnswer(RequestAnswerDto answer) {
        return solution.getCorrect().equals(answer.getSubmitAnswer());
    }

    protected void updateProblem(UpdateProblemDto updateProblemDto) {
        header = updateProblemDto.getHeader();
        body = updateProblemDto.getBody();
    }
}
