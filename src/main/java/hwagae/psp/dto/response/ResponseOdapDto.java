package hwagae.psp.dto.response;

import hwagae.psp.entity.Problem;
import lombok.Data;

@Data
public class ResponseOdapDto {
    private ResponseProblem problem;
    private ResponseSolutionDto solution;

    public ResponseOdapDto(Problem problem) {
        this.problem = new ResponseProblem(problem);
        this.solution = new ResponseSolutionDto(problem.getSolution());
    }
}
