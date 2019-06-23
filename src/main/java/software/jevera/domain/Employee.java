package software.jevera.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Column(unique = true)
    @Size(min = 10, max = 60)
    private String fullName;

    @NotNull
    @Column
    private Date dateOfBirth;

    @NotNull
    @Column
    private String sex;

    @Column
    private String nationality;

    @NotNull
    @Column
    private String workLocation;

    @NotNull
    @Column
    private String currentPosition;

    @NotNull
    @Column
    private Date startYearOfProfessionalExperience;

    @Column
    private String passwordHash;

    @ManyToMany
    @JoinTable( name = "employee_skill",
                joinColumns = @JoinColumn(referencedColumnName = "id", name = "employeeId"),
                inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "skillId"))
    private Set<Skill> skills;

}
