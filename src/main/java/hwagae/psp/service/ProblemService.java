package hwagae.psp.service;

import hwagae.psp.dto.request.RequestProblemDto;
import hwagae.psp.entity.MultipleProblem;
import hwagae.psp.entity.Problem;
import hwagae.psp.entity.SubjectiveProblem;
import hwagae.psp.entity.Workbook;
import hwagae.psp.repository.MultipleProblemRepository;
import hwagae.psp.repository.SubjectiveProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProblemService {

    private final MultipleProblemRepository multiRepository;
    private final SubjectiveProblemRepository subRepository;

    public long getAllProblemCount() {
        return ((multiRepository.count())+(subRepository.count()));
    }

    public Problem saveProblem(RequestProblemDto requestProblem, Workbook workbook) {
        if(requestProblem.getType().equals("MULTIPLE")) {
               return saveMultipleProblem(requestProblem, workbook);
        }

        return saveSubjectiveProblem(requestProblem, workbook);
    }

    public void updateProblem() {

    }

    private Problem saveMultipleProblem(RequestProblemDto requestProblem, Workbook workbook) {
        MultipleProblem saveProblem = MultipleProblem.builder()
                .header(requestProblem.getHeader())
                .body(requestProblem.getBody())
                .workbook(workbook)
                .selectNum(requestProblem.getSelectorNum())
                .selectContent(requestProblem.getSelectorContent())
                .build();

        return multiRepository.save(saveProblem);
    }

    private Problem saveSubjectiveProblem(RequestProblemDto requestProblem, Workbook workbook) {
        SubjectiveProblem saveProblem = SubjectiveProblem.builder()
                .header(requestProblem.getHeader())
                .body(requestProblem.getBody())
                .workbook(workbook)
                .build();

        return subRepository.save(saveProblem);
    }
}
