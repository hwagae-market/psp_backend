package hwagae.psp.service;

import hwagae.psp.dto.request.RequestComplainDto;
import hwagae.psp.dto.response.ResponseComplainDto;
import hwagae.psp.entity.Complain;
import hwagae.psp.entity.Problem;
import hwagae.psp.repository.ComplainRepository;
import hwagae.psp.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ComplainService {

    private final ComplainRepository complainRepository;
    private final ProblemRepository problemRepository;

    public void createComplain(RequestComplainDto complainDto) {
        Optional<Problem> optProblem = problemRepository.findById(complainDto.getProblemId());

        if(optProblem.isEmpty())
            throw new RuntimeException();

        Problem problem = optProblem.get();
        Complain complain = Complain.builder()
                .reason(complainDto.getReason())
                .detail(complainDto.getDetail())
                .problem(problem)
                .build();

        problem.addComplain(complainRepository.save(complain));
    }

    public List<ResponseComplainDto> getComplaionList(Long problemId) {
        Optional<Problem> optProblem = problemRepository.findById(problemId);

        if(optProblem.isEmpty())
            throw new RuntimeException();

        Problem problem = optProblem.get();
        return problem.getComplainList().stream().map(ResponseComplainDto::new).toList();
    }
}
