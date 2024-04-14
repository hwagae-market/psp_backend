package hwagae.psp.service;

import hwagae.psp.dto.request.RequestAnswerDto;
import hwagae.psp.dto.request.RequestProblemDto;
import hwagae.psp.dto.request.UpdateProblemDto;
import hwagae.psp.entity.*;
import hwagae.psp.repository.MultipleProblemRepository;
import hwagae.psp.repository.ProblemRepository;
import hwagae.psp.repository.SubjectiveProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProblemService {

    private final MultipleProblemRepository multiRepository;
    private final SubjectiveProblemRepository subRepository;
    private final ProblemRepository problemRepository;
    private final SolutionService solutionService;

    public long getAllProblemCount() {
        return ((multiRepository.count())+(subRepository.count()));
    }

    public Problem saveProblem(RequestProblemDto requestProblem, Workbook workbook) {
        if(requestProblem.getType().equals("MULTIPLE")) {
               return saveMultipleProblem(requestProblem, workbook);
        }

        return saveSubjectiveProblem(requestProblem, workbook);
    }

    public void updateProblem(UpdateProblemDto problemDto) {
        Optional<Problem> optionalProblem = problemRepository.findById(problemDto.getId());

        if(optionalProblem.isEmpty())
            throw new RuntimeException();

        Problem problem = optionalProblem.get();

        if(problem instanceof MultipleProblem) {
            ((MultipleProblem) problem).updateProblem(problemDto);
            return;
        }

        ((SubjectiveProblem) problem).updateProblem(problemDto);
    }

    public boolean solved(RequestAnswerDto answerDto) {
        Optional<Problem> optionalProblem = problemRepository.findById(answerDto.getProblemId());

        if(optionalProblem.isEmpty())
            throw new RuntimeException();

        Problem problem = optionalProblem.get();
        return problem.isRightAnswer(answerDto);
    }

    private Problem saveMultipleProblem(RequestProblemDto requestProblem, Workbook workbook) {
        MultipleProblem saveProblem = MultipleProblem.builder()
                .header(requestProblem.getHeader())
                .body(requestProblem.getBody())
                .workbook(workbook)
                .selectNum(requestProblem.getSelectorNum())
                .selectContent(requestProblem.getSelectorContent())
                .build();

        MultipleProblem multipleProblem = multiRepository.save(saveProblem);
        Solution savedSolution = solutionService.saveSolution(requestProblem.getSolution(), multipleProblem);
        multipleProblem.setSolution(savedSolution);

        return multipleProblem;
    }

    private Problem saveSubjectiveProblem(RequestProblemDto requestProblem, Workbook workbook) {
        SubjectiveProblem saveProblem = SubjectiveProblem.builder()
                .header(requestProblem.getHeader())
                .body(requestProblem.getBody())
                .workbook(workbook)
                .build();

        SubjectiveProblem subjectiveProblem = subRepository.save(saveProblem);

        Solution savedSolution = solutionService.saveSolution(requestProblem.getSolution(), subjectiveProblem);
        subjectiveProblem.setSolution(savedSolution);

        return subjectiveProblem;
    }
}
