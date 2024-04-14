package hwagae.psp.dto.request;

import hwagae.psp.entity.Solution;
import lombok.Data;

@Data
public class RequestSolutionDto {

    private String correct;
    private String comment;

    public Solution toEntity() {
        return Solution.builder()
                .correct(this.correct)
                .comment(this.comment)
                .build();
    }
}
