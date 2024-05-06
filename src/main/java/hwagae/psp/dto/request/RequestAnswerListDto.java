package hwagae.psp.dto.request;

import lombok.Data;

import java.util.List;

/**
 * 사용자가 제출한 답안 리스트
 */
@Data
public class RequestAnswerListDto {

    private List<RequestAnswerDto> answerList;
}
