package hwagae.psp.service;

import hwagae.psp.dto.request.RequestOdapDto;
import hwagae.psp.dto.request.RequestOdapNoteDto;
import hwagae.psp.dto.response.ResponseOdapNoteDto;
import hwagae.psp.entity.Odap;
import hwagae.psp.entity.OdapNote;
import hwagae.psp.entity.Problem;
import hwagae.psp.entity.User;
import hwagae.psp.exception.NoSuchUserException;
import hwagae.psp.repository.OdapNoteRepository;
import hwagae.psp.repository.OdapRepository;
import hwagae.psp.repository.ProblemRepository;
import hwagae.psp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 오답노트 관련 서비스를 처리를 모왔습니다.
 * 오답노트 및 관련 기능은 해당 서비스내에 위치해주세요.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class OdapNoteService {

    private final OdapNoteRepository odapNoteRepository;
    private final OdapRepository odapRepository;
    private final UserRepository userRepository;
    private final ProblemRepository problemRepository;

    public void saveOdapNote(RequestOdapNoteDto odapNoteDto) {
        Optional<User> optUser = userRepository.findById(odapNoteDto.getUserId());

        if (optUser.isEmpty())
            throw new NoSuchUserException();

        User targetUser = optUser.get();
        List<RequestOdapDto> requestOdapList = odapNoteDto.getOdapList();
        List<Odap> odapList = new ArrayList<>();

        for (RequestOdapDto odapDto : requestOdapList) {
            Problem problem = (Problem) problemRepository.findById(odapDto.getProblemId()).orElseThrow();
            Odap odap = odapRepository.save(Odap.builder().problem(problem).submit(odapDto.getAnswer()).build());
            odapList.add(odap);
        }

        OdapNote odapNote = OdapNote.builder().user(targetUser).odapNote(odapList).build();
        OdapNote saveNote = odapNoteRepository.save(odapNote);
        targetUser.addOdapNote(saveNote);

    }

    public ResponseOdapNoteDto findOdapNoteById(Long id) {
        OdapNote odapNote = odapNoteRepository.findById(id).orElseThrow();

        return new ResponseOdapNoteDto(odapNote);
    }

    public List<ResponseOdapNoteDto> findOdapNoteByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
        List<OdapNote> odapNoteList = user.getOdapNoteList();

        return odapNoteList.stream().map(ResponseOdapNoteDto::new).toList();
    }
}
