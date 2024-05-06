package hwagae.psp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 문제 풀이 결과 안내 Dto
 * 문제 PK보다는 문제 번호로 안내하는 편이 좋을듯
 * 해당 기능으로 수정 예정
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseAnswerDto {
    private int rightCount;//맞은 문제 개수
    private int wrongCount;//틀린 문제 개수
    private List<Long> rightProblemList;//맞은 문제 PK
    private List<Long> wrongProblemList;//틀린 문제 PK
}
