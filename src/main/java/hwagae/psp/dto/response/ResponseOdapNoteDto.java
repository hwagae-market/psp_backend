package hwagae.psp.dto.response;

import hwagae.psp.entity.OdapNote;
import lombok.Data;

import java.util.List;

@Data
public class ResponseOdapNoteDto {
    private List<ResponseOdapDto> odapList;

    public ResponseOdapNoteDto(OdapNote odapNote) {
        this.odapList =
                odapNote.getOdapNote().stream().map(o -> new ResponseOdapDto(o.getProblem())).toList();
    }
}

