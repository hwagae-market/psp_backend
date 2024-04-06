package hwagae.psp.entity;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
@DiscriminatorColumn(name = "type")
public class Problem extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String header;//문제 타이틀
    private String body;//본문 내용
}
