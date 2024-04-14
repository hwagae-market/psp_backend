package hwagae.psp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseAnswerDto {
    private int rightCount;
    private int wrongCount;
    private List<Long> rightProblemList;
    private List<Long> wrongProblemList;
}
