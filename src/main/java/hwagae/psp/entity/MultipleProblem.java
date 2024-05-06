package hwagae.psp.entity;

import hwagae.psp.dto.request.UpdateProblemDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * 객관식 문제 엔티티
 */
@Entity
@Getter
@DiscriminatorValue("multiple")
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class MultipleProblem extends Problem {
    List<Integer> selectNum;//객관식 번호
    List<String> selectContent;//객관식 보기값

    public void updateProblem(UpdateProblemDto updateProblemDto) {
        super.updateProblem(updateProblemDto);
        this.selectNum = updateProblemDto.getSelectorNum();
        this.selectContent = updateProblemDto.getSelectorContent();
    }
}