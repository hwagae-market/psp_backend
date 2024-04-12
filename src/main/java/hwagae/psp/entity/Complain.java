package hwagae.psp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Complain {

    @Id
    @GeneratedValue
    private Long id;
    private String reason;//신고 사유
    private String detail;//자세한 신고 내용

    @ManyToOne
    private Problem problem;
}
