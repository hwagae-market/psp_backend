package hwagae.psp.dto.response;

import hwagae.psp.entity.MultipleProblem;
import hwagae.psp.entity.Problem;
import lombok.Data;

import java.util.List;

@Data
public class ResponseProblem {

    private String type;//문제 타입
    private String header;//문제 타이틀
    private String body;//본문 내용
    private List<Integer> selectorNum= null;
    private List<String> selectorContent = null;

    public ResponseProblem(Problem problem) {
        this.body = problem.getBody();
        this.header = problem.getHeader();

        if(problem instanceof MultipleProblem) {
            this.type = "Multiple";
            this.selectorNum = ((MultipleProblem) problem).getSelectNum();
            this.selectorContent = ((MultipleProblem) problem).getSelectContent();
        } else {
            this.type = "Subjective";
        }
    }
}
