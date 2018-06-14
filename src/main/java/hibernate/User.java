package hibernate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
@Entity @Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "login")
    private String login;

}

