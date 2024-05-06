package hwagae.psp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * 오답노트 엔티티
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OdapNote {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;//소유자

    @OneToMany
    @JoinColumn(name = "odap_id")
    private List<Odap> odapNote;
}
