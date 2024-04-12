package hwagae.psp.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class UpdateProblemDto {
    private Long id;
    private String type;//문제 타입
    private String header;//문제 타이틀
    private String body;//본문 내용
    private List<Integer> selectorNum;
    private List<String> selectorContent;
    private RequestSolutionDto solution;
}
