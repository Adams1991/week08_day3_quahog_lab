import db.DBHelper;
import models.Course;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args){

        Course course1 = new Course("SoftWare", "HND");
        DBHelper.save(course1);

        Student student1 = new Student("Iona", 27, 2386);
        Student student2 = new Student("Shaun", 27, 2376);

        DBHelper.save(student1);
        DBHelper.save(student2);

        List<Course> course = DBHelper.getAll(Course.class);


    }


}
