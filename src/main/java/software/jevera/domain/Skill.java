package software.jevera.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;


@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @JoinColumn(name = "category_fk")
    @ManyToOne
    private Category category;

    @Enumerated(value = EnumType.STRING)
    private SkillType skillType;

    public Skill() {
    }

    public Skill(Long id, String name, Category category, SkillType skillType) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.skillType = skillType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", skillType=" + skillType +
                '}';
    }
}
