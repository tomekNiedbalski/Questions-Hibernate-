package hibernate;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "questions")
@Entity @Getter @Setter @EqualsAndHashCode @NoArgsConstructor
public class Question {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "text")
    private String text;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Answer> answers;
    @ManyToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<User> users;

    @Override
    public String toString() {
        return text;
    }
}
