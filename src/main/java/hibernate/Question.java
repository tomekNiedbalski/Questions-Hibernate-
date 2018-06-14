package hibernate;

import javax.persistence.*;
import lombok.*;

@Table(name = "questions")
@Entity @Getter @Setter @EqualsAndHashCode @NoArgsConstructor
public class Question {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "text")
    private String text;
}
