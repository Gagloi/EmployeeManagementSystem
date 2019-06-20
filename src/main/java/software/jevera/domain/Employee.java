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


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Employee() {
    }

    public Employee(Long id, String fullName, Date dateOfBirth, String sex, String nationality, String workLocation, String currentPosition, Date startYearOfProfessionalExperience, String passwordHash) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nationality = nationality;
        this.workLocation = workLocation;
        this.currentPosition = currentPosition;
        this.startYearOfProfessionalExperience = startYearOfProfessionalExperience;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Date getStartYearOfProfessionalExperience() {
        return startYearOfProfessionalExperience;
    }

    public void setStartYearOfProfessionalExperience(Date startYearOfProfessionalExperience) {
        this.startYearOfProfessionalExperience = startYearOfProfessionalExperience;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
