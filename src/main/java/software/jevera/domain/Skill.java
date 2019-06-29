package software.jevera.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skill")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id", unique = true)
    private Long id;

    @Column
    private String name;

    @JoinColumn(name = "category_fk")
    @ManyToOne
    private Category category;

    @Enumerated(value = EnumType.STRING)
    private SkillType skillType;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EmployeeSkill> employeeSkills;

}
