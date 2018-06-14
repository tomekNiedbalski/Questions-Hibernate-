package hibernate;

import javax.persistence.*;
import lombok.*;
import java.sql.Date;

@Table(name = "answers")
@Entity @Getter @Setter @EqualsAndHashCode @NoArgsConstructor
public class Answer {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "question_id")
    private int question_id;
    @Column(name = "text")
    private String text;
    @Column(name = "data")
    private Date date;
}
