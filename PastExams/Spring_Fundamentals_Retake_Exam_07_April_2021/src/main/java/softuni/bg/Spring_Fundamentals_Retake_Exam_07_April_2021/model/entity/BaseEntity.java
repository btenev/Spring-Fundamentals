package softuni.bg.Spring_Fundamentals_Retake_Exam_07_April_2021.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public BaseEntity(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
