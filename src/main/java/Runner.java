import db.DBHelper;
import db.DBInstructor;
import db.DBLesson;
import db.DBStudent;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args){

        Course course1 = new Course("SoftWare", "HND");
        DBHelper.save(course1);



        Student student1 = new Student("Iona", 27, 2386, course1);
        Student student2 = new Student("Shaun", 27, 2376, course1);

        DBHelper.save(student1);
        DBHelper.save(student2);

        Mentor mentor1 = new Mentor("Tony", student1);
        Mentor mentor2 = new Mentor("John", student2);

        Instructor instructor1= new Instructor("Newton");
        DBHelper.save(instructor1);

        DBHelper.save(mentor1);
        DBHelper.save(mentor2);

        Lesson lesson1 = new Lesson("Pizza Shop", 5, course1, instructor1);
        Lesson lesson2 = new Lesson("Kareoke", 3, course1, instructor1);

        DBHelper.save(lesson1);
        DBHelper.save(lesson2);


        List<Course> course = DBHelper.getAll(Course.class);

        List<Student> students = DBHelper.getAll(Student.class);

        List<Lesson> lessons = DBHelper.getAll(Lesson.class);

        Course getCourseOfStudent = DBStudent.getCourseFromStudent(student1);

        Course getCourseOfLesson = DBLesson.getCourseFromLesson(lesson1);

        Mentor getMentorForStudent = DBStudent.getMentorForStudent(student1);

        Instructor getInstructorForLesson = DBLesson.getInstructorForLesson(lesson1);

        List<Lesson> getLessonsForInstructor = DBInstructor.getLessons(instructor1);

    }


}
