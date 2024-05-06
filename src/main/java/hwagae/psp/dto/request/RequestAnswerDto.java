package hwagae.psp.dto.request;

import lombok.Data;

/**
 * 문제에 대한 사용자 제출 답안
 */
@Data
public class RequestAnswerDto {

    private Long problemId;
    private String submitAnswer;
}
