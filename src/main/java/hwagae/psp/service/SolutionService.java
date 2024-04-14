package hwagae.psp.service;

import hwagae.psp.dto.request.RequestSolutionDto;
import hwagae.psp.dto.response.ResponseSolutionDto;
import hwagae.psp.entity.Problem;
import hwagae.psp.entity.Solution;
import hwagae.psp.repository.ProblemRepository;
import hwagae.psp.repository.SolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SolutionService {

    private final SolutionRepository solutionRepository;
    private final ProblemRepository problemRepository;

    public Solution saveSolution(RequestSolutionDto solutionDto, Problem problem) {
        Solution solution = solutionRepository.save(solutionDto.toEntity());
        solution.setProblem(problem);
        return solution;
    }

    public ResponseSolutionDto findById(Long id) {
        Optional<Problem> optionalProblem = problemRepository.findById(id);

        if(optionalProblem.isEmpty())
            throw new RuntimeException();

        Problem targetProblem = optionalProblem.get();
        Solution targetProblemSolution = targetProblem.getSolution();

        return new ResponseSolutionDto(targetProblemSolution);
    }

    public void updateSolution(RequestSolutionDto requestSolutionDto, Long id) {
        Optional<Problem> optionalProblem = problemRepository.findById(id);

        if(optionalProblem.isEmpty())
            throw new RuntimeException();

        Problem targetProblem = optionalProblem.get();
        Solution targetProblemSolution = targetProblem.getSolution();
        targetProblemSolution.update(requestSolutionDto);
    }
}
