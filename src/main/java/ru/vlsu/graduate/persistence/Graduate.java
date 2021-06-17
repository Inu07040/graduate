package ru.vlsu.graduate.persistence;

import javax.persistence.*;

@Entity
@Table(name = "graduate")
public class Graduate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private AcGroup group;

    public Graduate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AcGroup getGroup() {
        return group;
    }

    public void setGroup(AcGroup group) {
        this.group = group;
    }
}
