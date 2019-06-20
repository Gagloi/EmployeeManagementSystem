package software.jevera.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
@Data
@EqualsAndHashCode(of = "fullName")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Column
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

    //private Set<EmployeeSkill> skills;

}
