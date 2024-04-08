package hwagae.psp.service;

import hwagae.psp.dto.request.RequestSolutionDto;
import hwagae.psp.dto.response.ResponseSolutionDto;
import hwagae.psp.entity.Problem;
import hwagae.psp.entity.Solution;
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

    public Solution saveSolution(RequestSolutionDto solutionDto, Problem problem) {
        Solution solution = solutionRepository.save(solutionDto.toEntity());
        solution.setProblem(problem);
        return solution;
    }

    public ResponseSolutionDto findById(Long id) {
        Optional<Solution> optionalSolution = solutionRepository.findById(id);

        if(optionalSolution.isEmpty())
            return null;//정답이 등록되지 않는 경우 처리를 어떻게 할까나

        Solution findSolution = optionalSolution.get();
        return new ResponseSolutionDto(findSolution);
    }
}
