package software.jevera.domain;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employee_id", unique = true, nullable = false)
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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<EmployeeSkill> skills = new HashSet<>();

    public Employee(@NotNull @Size(min = 10, max = 60) String fullName, @NotNull Date dateOfBirth, @NotNull String sex, String nationality, @NotNull String workLocation, @NotNull String currentPosition, @NotNull Date startYearOfProfessionalExperience) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.workLocation = workLocation;
        this.currentPosition = currentPosition;
        this.startYearOfProfessionalExperience = startYearOfProfessionalExperience;

    }

    public void addSkill(EmployeeSkill skill){
        this.skills.add(skill);
    }

}
