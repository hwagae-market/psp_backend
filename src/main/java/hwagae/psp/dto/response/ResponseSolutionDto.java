package hwagae.psp.dto.response;

import hwagae.psp.dto.request.RequestSolutionDto;
import hwagae.psp.entity.Solution;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseSolutionDto {
    private String correct;
    private String comment;

    public ResponseSolutionDto(Solution solution) {
        this.correct = solution.getCorrect();
        this.comment = solution.getComment();
    }
}
