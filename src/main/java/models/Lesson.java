package models;


import javax.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson {
    private int id;
    private  String title;
    private int classroom;

    public Lesson(String title, int classroom) {
        this.title = title;
        this.classroom = classroom;
    }

    public Lesson() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "classroom")
    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }
}
