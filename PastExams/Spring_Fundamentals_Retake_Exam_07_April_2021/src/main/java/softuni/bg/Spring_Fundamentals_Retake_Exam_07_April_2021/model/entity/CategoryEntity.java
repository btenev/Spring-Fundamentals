package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private NameEnum name;

    @Column(name = "needed_time")
    private int neededTime;

    public CategoryEntity() {
    }

    public NameEnum getName() {
        return name;
    }

    public void setName(NameEnum name) {
        this.name = name;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }

    //	The needed time for a Drink is 1 min.
    //	The needed time for Coffee is 2 min.
    //	The needed time for an Other is 5 min.
    //	The needed time for a Cake is 10 min.
}
