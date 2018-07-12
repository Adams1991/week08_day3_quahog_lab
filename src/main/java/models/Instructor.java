package models;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class Instructor {

    private String name;
    private List<Lesson> lessons;


    public Instructor(String name) {
        this.name = name;
        this.lessons = lessons;
    }

    public Instructor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
