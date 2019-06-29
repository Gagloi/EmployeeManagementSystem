package software.jevera.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "login")
@Entity
@Table(name = "ems_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    private String passwordHash;
    private String login;

    public User(String login) {
        this.login = login;
    }
}
